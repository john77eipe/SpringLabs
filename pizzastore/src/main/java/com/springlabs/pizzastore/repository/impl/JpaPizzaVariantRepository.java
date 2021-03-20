package com.springlabs.pizzastore.repository.impl;

import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.domain.PizzaOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlabs.pizzastore.domain.PizzaVariant;
import com.springlabs.pizzastore.repository.PizzaVariantRepository;

import java.util.List;

@Repository
public interface JpaPizzaVariantRepository extends JpaRepository<PizzaVariant, Long>, PizzaVariantRepository {

}