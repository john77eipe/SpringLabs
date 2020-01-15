package com.springlabs.pizzastore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springlabs.pizzastore.domain.Category;
import com.springlabs.pizzastore.service.PizzaService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	PizzaService pizzaService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/pizza/form")
    public ModelAndView createPizzaForm(ModelAndView modelAndView) {
		logger.info("Pizza Form controller");
		List<Category> listCatagory = pizzaService.findAllPizzaCategories();
		if(listCatagory.isEmpty()) {
			//TODO: error page redirection
		}
		modelAndView.addObject("listCategory", listCatagory);
		modelAndView.setViewName("admin/admin");
		return modelAndView;
    }
}
