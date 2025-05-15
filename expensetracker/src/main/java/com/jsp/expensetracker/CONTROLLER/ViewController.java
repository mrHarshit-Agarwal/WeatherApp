package com.jsp.expensetracker.CONTROLLER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	// Home Page
	@RequestMapping({"/", "/index"})
	
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	// Register Page
		@RequestMapping("/register")
		public ModelAndView register() {
			return new ModelAndView("register");
		}
	
	// Login Page
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	

	// Dashboard
	@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		return new ModelAndView("dashboard");
	}

	// Category Pages
	@RequestMapping("/categories")
	public ModelAndView categories() {
		return new ModelAndView("category-list");
	}

	@RequestMapping("/add-category")
	public ModelAndView addCategory() {
		return new ModelAndView("add-category");
	}

	@RequestMapping("/edit-category")
	public ModelAndView editCategory() {
		return new ModelAndView("edit-category");
	}

	@RequestMapping("/delete-category")
	public ModelAndView deleteCategory() {
		return new ModelAndView("delete-category");
	}

	// Transaction Pages
	@RequestMapping("/transactions")
	public ModelAndView transactions() {
		return new ModelAndView("transaction-list");
	}

	@RequestMapping("/add-transaction")
	public ModelAndView addTransaction() {
		return new ModelAndView("add-transaction");
	}

	@RequestMapping("/edit-transaction")
	public ModelAndView editTransaction() {
		return new ModelAndView("edit-transaction");
	}

	@RequestMapping("/delete-transaction")
	public ModelAndView deleteTransaction() {
		return new ModelAndView("delete-transaction");
	}

}
