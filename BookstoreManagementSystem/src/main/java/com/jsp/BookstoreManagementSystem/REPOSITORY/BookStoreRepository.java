package com.jsp.BookstoreManagementSystem.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.BookstoreManagementSystem.DTO.BookStore;


public interface BookStoreRepository extends JpaRepository<BookStore, Integer> {

	// all methods of JpaRepository interface will be inherited
	
	 // Get book by title
    @Query("select b from BookStore b where b.title = ?1")
    public BookStore findByTitle(String title);

    // Get all books with price > 150
    @Query("select b from BookStore b where b.price > ?1")
    public List<BookStore> findByPriceGreaterThan(double price);
}
