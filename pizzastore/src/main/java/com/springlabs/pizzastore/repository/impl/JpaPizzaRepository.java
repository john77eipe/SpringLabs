package com.springlabs.pizzastore.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.repository.PizzaRepository;

@Repository
public interface JpaPizzaRepository extends JpaRepository<Pizza, Long>, PizzaRepository {

}
