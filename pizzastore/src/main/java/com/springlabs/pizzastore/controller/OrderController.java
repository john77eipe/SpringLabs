package com.springlabs.pizzastore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.service.OrderService;
import com.springlabs.pizzastore.service.PizzaService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	PizzaService pizzaService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// add to cart
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public RedirectView addStatus(@RequestParam("pizzaId") Long pizzaId) {
		logger.info("Order controller");
		Pizza pizza = pizzaService.getPizza(pizzaId);
		logger.info("Ordered pizza : "+pizza.toString());
//		orderService
		return new RedirectView("/pizza/all");
	}

	// place order

	// place shipping addr

	// make payment

	// complete order

	// fetch order status

	// fetch order history
}