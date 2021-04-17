package com.springlabs.pizzastore.service;

import java.util.List;
import java.util.Map;

import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.domain.PizzaOption;
import com.springlabs.pizzastore.domain.PizzaVariant;

public interface PizzaService {
	
	/**
     * List all Pizzas from repository
     *
     * @return
     */
    List<Pizza> getAllPizzas();

    /**
     * Save a pizza to the repository
     *
     * @param pizza to save
     */
    Pizza savePizza(final Pizza pizza);
    
    /**
     * Find all details about one pizza
     * 
     * @param pizzaId
     */
    Pizza getPizza(final long pizzaId);

	/**
	 * Find PizzaVariant by pizzaVariantId
	 * 
	 * @param pizzaVariantId
	 * 
	 */
	PizzaVariant getPizzaVariant(Long pizzaVariantId);

	/**
	 * List all Pizza variants from repository
	 * 
	 * @return
	 */
	List<PizzaVariant> getAllPizzaVariants();

	PizzaVariant savePizzaVariant(final PizzaVariant pizza);

	PizzaOption savePizzaOption(final PizzaOption pizzaOption);

	PizzaOption getPizzaOption(final String optionType, final String optionValue);
}