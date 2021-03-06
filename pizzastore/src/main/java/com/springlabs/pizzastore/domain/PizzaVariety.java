package com.springlabs.pizzastore.domain;

import java.util.List;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_pizza_variety")
public class PizzaVariety {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@OneToMany
	@JoinColumn(name = "pizza_variant_id")
	private List<PizzaVariant> pizzaVariants;

	@ManyToMany
	@JoinColumn(name = "pizza_option_id")
	private List<PizzaOption> pizzaOptions;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PizzaVariant> getPizzaVariants() {
		return pizzaVariants;
	}

	public void setPizzaVariants(List<PizzaVariant> pizzaVariants) {
		this.pizzaVariants = pizzaVariants;
	}

	public List<PizzaOption> getPizzaOptions() {
		return pizzaOptions;
	}

	public void setPizzaOptions(List<PizzaOption> pizzaOptions) {
		this.pizzaOptions = pizzaOptions;
	}


	@Override
	public String toString() {
		return new StringJoiner(", ", PizzaVariety.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("pizzaVariants=" + pizzaVariants)
				.add("pizzaOptions=" + pizzaOptions)
				.toString();
	}
}