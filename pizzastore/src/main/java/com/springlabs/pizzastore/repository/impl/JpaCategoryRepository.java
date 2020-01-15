package com.springlabs.pizzastore.repository.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springlabs.pizzastore.domain.Category;
import com.springlabs.pizzastore.repository.CategoryRepository;

@Repository
public interface JpaCategoryRepository extends JpaRepository<Category, Long>, CategoryRepository {
	
	@Query(value = "SELECT C.id as id, C.category as category FROM tbl_category C INNER JOIN tbl_pizza_category_map PCM ON PCM.category_id = C.id where PCM.pizza_id=:pizzaId", 
			nativeQuery = true)
	List<Category> fetchSecondaryPizzaCategories(@Param("pizzaId") Long pizzaId);
}
