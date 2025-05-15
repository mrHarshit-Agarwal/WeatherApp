package com.jsp.expensetracker.REPOSITORY;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.expensetracker.DTO.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
   // User findByEmail(String email);
   Optional<User> findByEmail(String email);

}
