package com.jsp.expensetracker.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.jsp.expensetracker.DTO.Transaction;
import com.jsp.expensetracker.DTO.User;
import com.jsp.expensetracker.SERVICE.TransactionService;
import com.jsp.expensetracker.SERVICE.UserService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	@Autowired
	private UserService userService;

	@PostMapping("/income")
	public Transaction createIncome(@Validated @RequestBody Transaction transaction) {
		return transactionService.createTransaction(transaction, "income");
	}

	@PostMapping("/expense")
	public Transaction createExpense(@Validated @RequestBody Transaction transaction) {
		return transactionService.createTransaction(transaction, "expense");
	}

	// For income transactions
	@GetMapping("/income")
	public List<Transaction> getAllIncome(@RequestParam Long userId) {
		// Fetch user by ID
		User user = userService.findUserById(userId);
		return transactionService.getAllTransactions(user, "income");
	}

	// For expense transactions
	@GetMapping("/expense")
	public List<Transaction> getAllExpense(@RequestParam Long userId) {
		// Fetch user by ID
		User user = userService.findUserById(userId);
		return transactionService.getAllTransactions(user, "expense");
	}

	@PutMapping("/income/{id}")
	public Transaction updateIncome(@PathVariable Long id, @Valid @RequestBody Transaction transaction) {
		return transactionService.updateTransaction(id, transaction);
	}

	@PutMapping("/expense/{id}")
	public Transaction updateExpense(@PathVariable Long id, @Valid @RequestBody Transaction transaction) {
		return transactionService.updateTransaction(id, transaction);
	}

	@DeleteMapping("/income/{id}")
	public String deleteIncome(@PathVariable Long id) {
		return transactionService.deleteTransaction(id);
	}

	@DeleteMapping("/expense/{id}")
	public String deleteExpense(@PathVariable Long id) {
		return transactionService.deleteTransaction(id);
	}
}
