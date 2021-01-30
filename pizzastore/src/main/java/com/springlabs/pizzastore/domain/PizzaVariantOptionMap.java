package com.springlabs.pizzastore.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "tbl_pizza_variant_option_map")
public class PizzaVariantOptionMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pizza_variant_id")
	private List<PizzaVariant> pizzaVariant;

	@ManyToOne
	@JoinColumn(name = "pizza_option_id")
	private List<Option> pizzaOption;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PizzaVariant> getPizzaVariant() {
		return pizzaVariant;
	}

	public void setPizzaVariant(List<PizzaVariant> pizzaVariant) {
		this.pizzaVariant = pizzaVariant;
	}

	public List<Option> getPizzaOption() {
		return pizzaOption;
	}

	public void setPizzaOption(List<Option> pizzaOption) {
		this.pizzaOption = pizzaOption;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PizzaVariantOptionMap [id=");
		builder.append(id);
		builder.append(", pizzaVariant=");
		builder.append(pizzaVariant);
		builder.append(", pizzaOption=");
		builder.append(pizzaOption);
		builder.append("]");
		return builder.toString();
	}

}