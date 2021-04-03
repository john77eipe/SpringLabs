package com.springlabs.pizzastore.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springlabs.pizzastore.domain.Order;
import com.springlabs.pizzastore.domain.OrderItem;
import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.domain.PizzaVariant;
import com.springlabs.pizzastore.repository.impl.JpaOrderItemRepository;
import com.springlabs.pizzastore.repository.impl.JpaOrderRepository;
import com.springlabs.pizzastore.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	JpaOrderRepository jpaOrderRepository;
	
	@Autowired
	JpaOrderItemRepository jpaOrderItemRepository; 

	@Override
	public Pizza orderPizza(Pizza pizza) {
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Order addToCart(Long userId, PizzaVariant pizzaVariant) {
		Order currentOrder = getCurrentOrder(userId);
		OrderItem item = new OrderItem();
		item.setPizzaVariant(pizzaVariant);
		item.setQuantity(BigDecimal.ONE);
		item.setUnitPrice(pizzaVariant.getPriceWithTax());
		item.setTotalPrice(item.getUnitPrice().multiply(item.getQuantity()));
		if (currentOrder == null) {
			currentOrder = new Order();
			currentOrder.setUserId(userId);
			currentOrder.setOrderState(0);
		}
		item.setOrder(currentOrder);
		currentOrder.getOrderItems().add(item);
		BigDecimal total = currentOrder.getOrderItems().stream().map(item1 -> item1.getTotalPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
		currentOrder.setTotal(total);
		currentOrder.setShippingCost(BigDecimal.TEN);
		jpaOrderItemRepository.save(item);
//		Order order = jpaOrderRepository.save(currentOrder);
		return currentOrder;
	}
	
	@Override
	public Order getCurrentOrder(Long userId) {
		return jpaOrderRepository.fetchCurrentOrderByUserId(userId);
	}

	@Override
	public Boolean cancelItemById(Long itemId) {
		logger.info(itemId.toString());
		Optional<OrderItem> item = jpaOrderItemRepository.findById(itemId);
		logger.info(item.toString());
		item.ifPresent(item1 -> jpaOrderItemRepository.delete(item1));
		return Boolean.TRUE;
	}
	
}