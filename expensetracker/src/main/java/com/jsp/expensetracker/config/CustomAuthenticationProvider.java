package com.jsp.expensetracker.config;

import com.jsp.expensetracker.DTO.User;
import com.jsp.expensetracker.SERVICE.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();
		String password = authentication.getCredentials().toString();

		User user = userService.findByEmail(email);

		if (user == null) {
			throw new BadCredentialsException("User not found");
		}

		// Use your UserService to check password
		if (!userService.checkPassword(password, user.getPassword())) {
			throw new BadCredentialsException("Invalid password");
		}

		// If authentication successful, return a fully authenticated token with roles
		// (add roles if you have)
		return new UsernamePasswordAuthenticationToken(email, password,
				Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
