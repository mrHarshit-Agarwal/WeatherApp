package com.jsp.expensetracker.CONTROLLER;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	//  created dummy

	    @GetMapping("/")
	    public String home() {
	        return "Welcome to the Expense Tracker API!";
	    }
	}
