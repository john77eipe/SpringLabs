package com.springlabs.pizzastore.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlabs.pizzastore.domain.PizzaVariant;
import com.springlabs.pizzastore.repository.PizzaVariantRepository;

@Repository
public interface JpaPizzaVariantRepository extends JpaRepository<PizzaVariant, Long>, PizzaVariantRepository {

}