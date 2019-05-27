package com.springlabs.pizzastore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class HomeController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping
    public String getAllPizzas() {
		// Note that you don't need a ModelAndView bean. Spring will take care of it if it's 
		// just a simple forward.
		logger.info("Welcome controller");
		return "welcome";
    }
}	