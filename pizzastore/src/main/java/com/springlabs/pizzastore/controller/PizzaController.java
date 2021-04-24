package com.springlabs.pizzastore.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.springlabs.pizzastore.domain.PizzaOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.springlabs.pizzastore.domain.CustomSecurityUser;
import com.springlabs.pizzastore.domain.Order;
import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.domain.PizzaVariant;
import com.springlabs.pizzastore.service.OrderService;
import com.springlabs.pizzastore.service.PizzaService;



@Controller
@RequestMapping("/pizza")
public class PizzaController {

	@Autowired
	PizzaService pizzaService;
	
	@Autowired
	OrderService orderService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/all")
    public ModelAndView getAllPizzas(ModelAndView modelAndView, Authentication authentication) {
		logger.info("Pizza controller - getAllPizzas");
		List<Pizza> pizzaList = pizzaService.getAllPizzas();
		
		if(pizzaList.isEmpty()) {
			logger.error("pizzaList is Empty");
			//TODO: error page redirection
		}
		logger.info("Pizza list: {}", pizzaList);
		modelAndView.addObject("pizzaList", pizzaList);
		if (authentication != null) {
			CustomSecurityUser customSecurityUser = (CustomSecurityUser) authentication.getPrincipal();
			Order currentOrder = orderService.getCurrentOrder(customSecurityUser.getId());
			modelAndView.addObject("currentOrder", currentOrder);
		}
		
		modelAndView.setViewName("pizza/pizzaList");
		return modelAndView;
    }
	
	@GetMapping("/{pizzaId}")
    public ModelAndView getPizza(@PathVariable final Long pizzaId, ModelAndView modelAndView) {
		logger.info("Pizza controller");
		Pizza pizza = pizzaService.getPizza(pizzaId);
		if(pizza==null) {
			//TODO: error page redirection
		}
		modelAndView.addObject("pizza", pizza);
		modelAndView.setViewName("pizza/pizza");
		return modelAndView;
    }
	
	@GetMapping("/pizzaForm")
    public ModelAndView newPizza(ModelAndView modelAndView) {
		logger.info("Pizza controller");
		modelAndView.setViewName("pizza/pizzaForm");
		return modelAndView;
    }
	
	@PostMapping("/save")
    public RedirectView savePizza(
    		@RequestParam(required = true) String pizzaName,
    		@RequestParam(required = true) String pizzaDesc) {
		logger.info("Pizza controller");
		Pizza pizzaSaved = pizzaService.savePizza(new Pizza(pizzaName, pizzaDesc));
		logger.info("Pizza saved: " + pizzaSaved);
		return new RedirectView("/pizza/all");
    }


	@PostMapping("/option/save")
	public RedirectView savePizzaOption(
			@RequestParam(required = true) String optionType,
			@RequestParam(required = true) String optionValue) {
		logger.info("Pizza controller");
		PizzaOption pizzaOptionSaved = pizzaService.savePizzaOption(new PizzaOption(optionType, optionValue));
		logger.info("Pizza Option saved: " + pizzaOptionSaved);
		return new RedirectView("/pizza/all");
	}


	@GetMapping("/variant/save")
	public RedirectView savePizzaVariant(
			@RequestParam Long pizzaId,
			@RequestParam String sku,
			@RequestParam BigDecimal price,
			@RequestParam(defaultValue = "100") Long quantityOnHand,
			@RequestParam(required = false, defaultValue = "1") Long outOfStockThreshold,
			@RequestParam(required = false, defaultValue = "0") BigDecimal tax,
			@RequestParam(required = true) Integer quantityOnSale,
			@RequestParam HashMap<String, String> pizzaOptions) {
		logger.info("Pizza controller");
		//fetch pizza linked to the variant/sku
		Pizza pizza = pizzaService.getPizza(pizzaId);
		//creating new variant/sku for that pizza using the given data
		PizzaVariant pizzaVariant = new PizzaVariant(sku, price, quantityOnHand, outOfStockThreshold, tax, quantityOnSale, pizza);
		//populating the variety and options mapping
		List<PizzaOption> pizzaOptionList = new ArrayList<>();
		pizzaOptions.forEach((k, v) -> {
			//create pizzaOption if it doesn't exists
			PizzaOption pizzaOption = pizzaService.getPizzaOption(k, v);
			if(pizzaOption==null) {
				pizzaOption = pizzaService.savePizzaOption(pizzaOption);
			}
			pizzaOptionList.add(pizzaOption);
		});
		//map PizzaVariant and Options
		pizzaVariant.setPizzaOptionList(pizzaOptionList);

		PizzaVariant pizzaVariantSaved = pizzaService.savePizzaVariant(pizzaVariant);
		logger.info(pizzaVariantSaved.toString());
		return new RedirectView("/pizza/all");
	}
}	