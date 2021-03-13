package com.springlabs.pizzastore.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springlabs.pizzastore.domain.Order;
import com.springlabs.pizzastore.repository.OrderRepository;

@Repository
public interface JpaOrderRepository extends JpaRepository<Order, Long>, OrderRepository {

	@Query("SELECT o FROM Order o WHERE o.userId = ?1 AND o.orderState = 0")
	public Order fetchCurrentOrderByUserId(Long userId);
	
}