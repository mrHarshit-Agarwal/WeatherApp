package com.jsp.expensetracker.CONTROLLER;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.expensetracker.DTO.Category;
import com.jsp.expensetracker.REPOSITORY.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    
    private CategoryRepository categoryRepository;

    @PostMapping
    public Object createCategory(@Validated @RequestBody Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            return "Category already exists.";
        }
        return categoryRepository.save(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PutMapping("/{id}")
    public Object updateCategory(@PathVariable Long id, @Validated @RequestBody Category category) {
        Optional<Category> existing = categoryRepository.findById(id);
        if (existing.isPresent()) {
            Category update = existing.get();
            update.setName(category.getName());
            return categoryRepository.save(update);
        }
        return "Category not found.";
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return "Category deleted successfully.";
        }
        return "Category not found.";
    }
}



