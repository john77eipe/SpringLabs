package com.springlabs.pizzastore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springlabs.pizzastore.domain.Pizza;



@Controller
@RequestMapping("/pizza")
public class PizzaController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/all")
    public ModelAndView getAllPizzas() {
		logger.info("Pizza controller");
		List<Pizza> findAllPizzas = new ArrayList<Pizza>();
		ModelAndView modelAndView = new ModelAndView();
		if(findAllPizzas.isEmpty()) {
			Pizza p1 = new Pizza();
			p1.setName("cheez bust");
			findAllPizzas.add(p1);
		}
		modelAndView.addObject("pizzas", findAllPizzas);
		modelAndView.setViewName("pizza/pizzaList");
		return modelAndView;
    }
}	