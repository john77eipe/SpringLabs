package com.springlabs.pizzastore.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlabs.pizzastore.domain.Order;
import com.springlabs.pizzastore.domain.OrderItem;
import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.domain.PizzaVariant;
import com.springlabs.pizzastore.repository.impl.JpaOrderRepository;
import com.springlabs.pizzastore.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	JpaOrderRepository jpaOrderRepository;

	@Override
	public Pizza orderPizza(Pizza pizza) {
		return null;
	}

	@Override
	public Order addToCart(Long userId, PizzaVariant pizzaVariant) {
		Order currentOrder = jpaOrderRepository.fetchCurrentOrderByUserId(userId);
		OrderItem item = new OrderItem();
		item.setPizzaVariant(pizzaVariant);
		item.setQuantity(BigDecimal.ONE);
		item.setUnitPrice(pizzaVariant.getPriceWithTax());
		item.setTotalPrice(item.getUnitPrice().multiply(item.getQuantity()));
		currentOrder.getOrderItems().add(item);
		Order order = jpaOrderRepository.save(currentOrder);
		return order;
	}
	
}