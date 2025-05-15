package com.jsp.expensetracker.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.expensetracker.DTO.Category;
import com.jsp.expensetracker.REPOSITORY.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	// Method to create a new category
	public Category createCategory(Category category) {
		if (categoryRepository.existsByName(category.getName())) {
			throw new IllegalArgumentException("Category already exists.");
		}
		return categoryRepository.save(category);
	}

	// Method to get all categories
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	// Method to get a category by ID
	public Category getCategoryById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()) {
			return category.get();
		} else {
			throw new IllegalArgumentException("Category not found.");
		}
	}

	// Method to update an existing category
	public Category updateCategory(Long id, Category category) {
		Optional<Category> existingCategory = categoryRepository.findById(id);
		if (existingCategory.isPresent()) {
			Category update = existingCategory.get();
			update.setName(category.getName());
			return categoryRepository.save(update);
		} else {
			throw new IllegalArgumentException("Category not found.");
		}
	}

	// Method to delete a category
	public String deleteCategory(Long id) {
		if (categoryRepository.existsById(id)) {
			categoryRepository.deleteById(id);
			return "Category deleted successfully.";
		} else {
			throw new IllegalArgumentException("Category not found.");
		}
	}
}