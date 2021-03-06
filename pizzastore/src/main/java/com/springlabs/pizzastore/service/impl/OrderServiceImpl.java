package com.springlabs.pizzastore.service.impl;

import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.repository.impl.JpaOrderRepository;
import com.springlabs.pizzastore.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	JpaOrderRepository jpaOrderRepository;

	@Override
	public Pizza orderPizza(Pizza pizza) {
		Object entity;
		return null;
	}
}
