package com.jsp.BookstoreManagementSystem.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.BookstoreManagementSystem.DTO.BookStore;
import com.jsp.BookstoreManagementSystem.REPOSITORY.BookStoreRepository;

@Service
public class BookStoreService {

	@Autowired
	BookStoreRepository repository;

	// Create a new book
	public BookStore insertBook(BookStore bookstore) {
		return repository.save(bookstore);
	}

	// Get all books
	public List<BookStore> getAllBooks() {
		return repository.findAll();
	}

	// Get a book by ID
	public BookStore getBookById(int id) {
		Optional<BookStore> opt = repository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	// Update a book's title, publisher, price, and quantity

	public BookStore updateBook(int id, String newTitle, String newPublisher, double newPrice, int newQuantity) {
		BookStore book = getBookById(id);
		if (book != null) {
			book.setTitle(newTitle);
			book.setPublisher(newPublisher);
			book.setPrice(newPrice);
			book.setQuantity(newQuantity);
			return repository.save(book);
		}
		return null;
	}

	// Delete a book by ID

	public String deleteBook(int id) {
		BookStore book = getBookById(id);
		if (book != null) {
			repository.delete(book);
			return "Book record deleted successfully.";
		} else {
			return "Book record not found.";
		}
	}

	// Get a book by title
	public BookStore getBookByTitle(String title) {
		return repository.findByTitle(title);
	}

	// Get all books where price > 150
	public List<BookStore> getBooksByPrice(Double price) {
	    return repository.findByPriceGreaterThan(price);
	}

	
}


