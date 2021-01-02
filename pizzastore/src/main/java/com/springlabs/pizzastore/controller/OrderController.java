package com.springlabs.pizzastore.controller;

import com.springlabs.pizzastore.domain.Category;
import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.service.OrderService;
import com.springlabs.pizzastore.service.PizzaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	//place order

	//place shipping addr

	//make payment

	//complete order

	//fetch order status

	//fetch order history
}	