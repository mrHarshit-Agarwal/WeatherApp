package com.jsp.expensetracker.SERVICE;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import com.jsp.expensetracker.DTO.User;
import com.jsp.expensetracker.REPOSITORY.UserRepository;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    // Register user
    public String registerUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return "User already exists with this email.";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully.";
    }

    // Find user by ID
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }

    // Login user and return JWT token
    public String loginUser(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            return "Invalid email or password.";
        }

        User user = optionalUser.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "Invalid email or password.";
        }

        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000)) // 2 hours
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();

        return "Logged in successfully. Token: " + token;
    }

    // Used for authentication provider or internal checks
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
