package com.jsp.expensetracker.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.expensetracker.DTO.Transaction;
import com.jsp.expensetracker.DTO.User;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	 List<Transaction> findByUserAndType(User user, String type);

}
