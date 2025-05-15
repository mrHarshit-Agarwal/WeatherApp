package com.jsp.expensetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ExpensetrackerApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(ExpensetrackerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ExpensetrackerApplication.class, args);
	}

}



