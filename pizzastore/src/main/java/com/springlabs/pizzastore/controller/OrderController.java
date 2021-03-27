package com.springlabs.pizzastore.controller;



import com.springlabs.pizzastore.domain.CustomSecurityUser;
import com.springlabs.pizzastore.domain.Order;
import com.springlabs.pizzastore.domain.PizzaVariant;
import com.springlabs.pizzastore.service.OrderService;
import com.springlabs.pizzastore.service.PizzaService;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	PizzaService pizzaService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// add to cart
	@PostMapping("/addToCart")
	public RedirectView addToCart(@RequestParam("pizzaVariantId") Long pizzaVariantId, Authentication authentication) {
		logger.info("Order controller");
    
		CustomSecurityUser customSecurityUser = (CustomSecurityUser) authentication.getPrincipal();
		System.out.println("Principal: "+authentication.getPrincipal());
		System.out.println("User ID: "+ customSecurityUser.getId());
		System.out.println("User has authorities: " + customSecurityUser.getAuthorities());
		System.out.println("First name: "+ customSecurityUser.getFirstName());
		System.out.println("Email is: "+ customSecurityUser.getEmail());
		System.out.println("Year of Birth: "+ customSecurityUser.getYearOfBirth());

		PizzaVariant pizzaVariant = pizzaService.getPizzaVariant(pizzaVariantId);
		logger.info("Ordered pizza : ", pizzaVariant.toString());
		Order order = orderService.addToCart(customSecurityUser.getId(), pizzaVariant);
		return new RedirectView("/pizza/all");
	}
	
	@GetMapping("/getCart")
	public ModelAndView getCart(ModelAndView modelAndView, Authentication authentication) {
		CustomSecurityUser customSecurityUser = (CustomSecurityUser) authentication.getPrincipal();
		Order currentOrder = orderService.getCurrentOrder(customSecurityUser.getId());
		logger.info(currentOrder.toString());
		modelAndView.addObject("currentOrder", currentOrder);
		modelAndView.setViewName("order/cart");
		return modelAndView;
		
	}
	
	@PostMapping("/cancelItem")
	public RedirectView cancelItem(@RequestParam("itemId") Long itemId) {
		logger.info("itemId&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&", itemId);
		logger.info(itemId.toString());
		Boolean isCanceled = orderService.cancelItemById(itemId);
		return new RedirectView("order/cart");		
	}

	// place order

	// place shipping addr

	// make payment

	// complete order

	// fetch order status

	// fetch order history
}