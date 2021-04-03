package com.springlabs.pizzastore.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlabs.pizzastore.domain.OrderItem;
import com.springlabs.pizzastore.repository.OrderItemRepository;

@Repository
public interface JpaOrderItemRepository extends JpaRepository<OrderItem, Long>, OrderItemRepository {

}