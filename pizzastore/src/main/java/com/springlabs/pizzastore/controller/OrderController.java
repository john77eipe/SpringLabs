package com.springlabs.pizzastore.controller;

import com.springlabs.pizzastore.domain.Category;
import com.springlabs.pizzastore.domain.CustomSecurityUser;
import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.domain.UserAccount;
import com.springlabs.pizzastore.service.OrderService;
import com.springlabs.pizzastore.service.PizzaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.List;


@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	PizzaService pizzaService;

	@Autowired
	OrderService orderService;


	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//add to cart
	@GetMapping("/addToCart/{pizzaId}")
	public ModelAndView addToCart(@PathVariable final Long pizzaId, ModelAndView modelAndView, Authentication authentication) {
		logger.info("Pizza controller");

		CustomSecurityUser customSecurityUser = (CustomSecurityUser) authentication.getPrincipal();
		System.out.println("Principal: "+authentication.getPrincipal());
		System.out.println("User ID: "+ customSecurityUser.getId());
		System.out.println("User has authorities: " + customSecurityUser.getAuthorities());
		System.out.println("First name: "+ customSecurityUser.getFirstName());
		System.out.println("Email is: "+ customSecurityUser.getEmail());
		System.out.println("Year of Birth: "+ customSecurityUser.getYearOfBirth());

		Pizza pizza = pizzaService.getPizza(pizzaId);
		if(pizza==null) {
			//TODO: error page redirection
		}
		modelAndView.addObject("pizza", pizza);
		modelAndView.setViewName("pizza/pizza");
		return modelAndView;
	}

	//place order

	//place shipping addr

	//make payment

	//complete order

	//fetch order status

	//fetch order history
}	