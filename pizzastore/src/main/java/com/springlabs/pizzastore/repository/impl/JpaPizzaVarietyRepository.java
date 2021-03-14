package com.springlabs.pizzastore.repository.impl;

import com.springlabs.pizzastore.domain.PizzaVariety;
import com.springlabs.pizzastore.repository.PizzaVarietyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPizzaVarietyRepository extends JpaRepository<PizzaVariety, Long>, PizzaVarietyRepository {
}
