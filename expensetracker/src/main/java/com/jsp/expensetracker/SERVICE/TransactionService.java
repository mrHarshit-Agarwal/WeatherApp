package com.jsp.expensetracker.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.expensetracker.DTO.Transaction;
import com.jsp.expensetracker.DTO.User;
import com.jsp.expensetracker.REPOSITORY.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public Transaction createTransaction(Transaction transaction, String type) {
		transaction.setType(type);
		return transactionRepository.save(transaction);
	}

	public List<Transaction> getAllTransactions(User user, String type) {
		return transactionRepository.findByUserAndType(user, type);
	}

	public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
		Optional<Transaction> optional = transactionRepository.findById(id);
		if (optional.isPresent()) {
			Transaction t = optional.get();
			t.setAmount(updatedTransaction.getAmount());
			t.setCategory(updatedTransaction.getCategory());
			t.setDate(updatedTransaction.getDate());
			t.setType(updatedTransaction.getType());
			return transactionRepository.save(t);
		}
		return null;
	}

	public String deleteTransaction(Long id) {
		if (transactionRepository.existsById(id)) {
			transactionRepository.deleteById(id);
			return "Transaction deleted successfully.";
		}
		return "Transaction not found.";
	}
}
