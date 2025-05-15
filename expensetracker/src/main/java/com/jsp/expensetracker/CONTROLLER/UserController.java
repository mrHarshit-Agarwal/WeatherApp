package com.jsp.expensetracker.CONTROLLER;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.jsp.expensetracker.DTO.User;
import com.jsp.expensetracker.REPOSITORY.UserRepository;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("Email is already in use.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);

        return ResponseEntity.ok("User registered successfully with email: " + savedUser.getEmail());
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(401).body("Invalid email or password.");
        }

        User user = optionalUser.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid email or password.");
        }

        String token = Jwts.builder()
                .setSubject(user.getEmail())
                .claim("name", user.getName())
                .claim("email", user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000)) // 2 hours
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", Map.of("name", user.getName(), "email", user.getEmail()));

        return ResponseEntity.ok(response);
    }
}
