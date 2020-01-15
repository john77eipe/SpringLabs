package com.springlabs.pizzastore.repository;

import java.util.List;

import com.springlabs.pizzastore.domain.Category;

public interface CategoryRepository  {
	List<Category> fetchSecondaryPizzaCategories(Long pizzaId);
}