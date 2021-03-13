package com.springlabs.pizzastore.service;

import java.util.List;

import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.domain.PizzaVariant;

public interface PizzaService {
	
	/**
     * List all Pizzas from repository
     *
     * @return
     */
    List<Pizza> findAllPizzas();

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
	List<PizzaVariant> findAllPizzaVariant();

}