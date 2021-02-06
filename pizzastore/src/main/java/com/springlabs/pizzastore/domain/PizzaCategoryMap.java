package com.springlabs.pizzastore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.StringJoiner;

@Entity
@Table(name="tbl_pizza_category_map")
public class PizzaCategoryMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "product_id")
	private Pizza product;
	
	@ManyToOne
    @JoinColumn(name = "category_id")
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pizza getProduct() {
		return product;
	}

	public void setProduct(Pizza product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", PizzaCategoryMap.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("product=" + product)
				.add("category=" + category)
				.toString();
	}
}
