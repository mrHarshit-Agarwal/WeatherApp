package com.jsp.BookstoreManagementSystem.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.BookstoreManagementSystem.DTO.BookStore;
import com.jsp.BookstoreManagementSystem.SERVICE.BookStoreService;


@RestController
public class BookStoreController {
	
	@Autowired
	BookStoreService service;
	
	// REST API TO INSERT A BOOK INTO DB
    @PostMapping("/books")
    public BookStore insertBook(@RequestBody BookStore bs) {
        return service.insertBook(bs);
    }

    // REST API TO GET ALL BOOKS FROM DB
    @GetMapping("/books")
    public List<BookStore> getAllBooks() {
        return service.getAllBooks();
    }

    // REST API TO GET A BOOK BY ID
    @GetMapping("/getbook")
    public BookStore getBookById(@RequestParam int id) {
        return service.getBookById(id);
    }

    // REST API TO UPDATE BOOK DETAILS (title, publisher, price, quantity)
    @PutMapping("/books")
    public BookStore updateBook(@RequestParam int id, @RequestParam String title, @RequestParam String publisher,
                             @RequestParam double price, @RequestParam int quantity) {
        return service.updateBook(id, title, publisher, price, quantity);
    }

    // REST API TO DELETE A BOOK BY ID
    @DeleteMapping("/books")
    public String deleteBook(@RequestParam int id) {
        return service.deleteBook(id);
    }

    // REST API TO GET A BOOK BY TITLE
    @GetMapping("/booktitle")
    public BookStore getBookByTitle(@RequestParam String title) {
        return service.getBookByTitle(title);
    }

    // REST API TO GET ALL BOOKS WITH PRICE > 150
    @GetMapping("/price")
    public List<BookStore> getBooksPrice(@RequestParam Double price) {
        return service.getBooksByPrice(price);
    }
}

