package com.springlabs.pizzastore.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springlabs.pizzastore.domain.PizzaCategory;
import com.springlabs.pizzastore.repository.PizzaCategoryRepository;

@Repository
public interface JpaPizzaCategoryRepository extends JpaRepository<PizzaCategory, Long>, PizzaCategoryRepository {

}
