package com.springlabs.pizzastore.domain;

import java.util.List;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_pizza_variant_option_map")
public class PizzaVariantOptionMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pizza_variant_id")
	private PizzaVariant pizzaVariant;

	@ManyToOne
	@JoinColumn(name = "pizza_option_id")
	private Option pizzaOption;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PizzaVariant getPizzaVariant() {
		return pizzaVariant;
	}

	public void setPizzaVariant(PizzaVariant pizzaVariant) {
		this.pizzaVariant = pizzaVariant;
	}

	public Option getPizzaOption() {
		return pizzaOption;
	}

	public void setPizzaOption(Option pizzaOption) {
		this.pizzaOption = pizzaOption;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", PizzaVariantOptionMap.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("pizzaVariant=" + pizzaVariant)
				.add("pizzaOption=" + pizzaOption)
				.toString();
	}

}