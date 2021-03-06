package com.springlabs.pizzastore.service;

import com.springlabs.pizzastore.domain.Pizza;

public interface OrderService {
	
    /**
     * order a pizza to the repository
     *
     * @param pizza to save
     */
    Pizza orderPizza(final Pizza pizza);

}
