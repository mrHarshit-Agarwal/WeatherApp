package com.jsp.expensetracker.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.expensetracker.DTO.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);

}
