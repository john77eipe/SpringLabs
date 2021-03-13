package com.springlabs.pizzastore.service;

import com.springlabs.pizzastore.domain.Order;
import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.domain.PizzaVariant;

public interface OrderService {
	
    /**
     * order a pizza to the repository
     *
     * @param pizza to save
     */
    Pizza orderPizza(final Pizza pizza);

	/**
	 * @param id
	 * @param pizzaVariant
	 * @return
	 */
	Order addToCart(Long id, PizzaVariant pizzaVariant);

}