package com.springlabs.pizzastore.repository.impl;

import com.springlabs.pizzastore.domain.PizzaOption;
import com.springlabs.pizzastore.repository.PizzaOptionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPizzaOptionRepository extends JpaRepository<PizzaOption, Long>, PizzaOptionRepository, QueryByExampleExecutor<PizzaOption> {


}
