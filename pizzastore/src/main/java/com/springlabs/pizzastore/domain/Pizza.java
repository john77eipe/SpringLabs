package com.springlabs.pizzastore.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_pizza")
public class Pizza extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Size(min = 2)
	@Column(name = "`name`")
	private String name;

	@Column(name = "`desc`")
	private String description;

	@OneToMany(mappedBy = "pizza", targetEntity = PizzaVariant.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PizzaVariant> pizzaVariantList = new ArrayList<>();

	public Pizza(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Pizza() {
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PizzaVariant> getPizzaVariantList() {
		return pizzaVariantList;
	}

	public void setPizzaVariantList(List<PizzaVariant> pizzaVariantList) {
		this.pizzaVariantList = pizzaVariantList;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Pizza.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("name='" + name + "'")
				.add("description='" + description + "'")
				.add("pizzaVariantList=" + pizzaVariantList)
				.toString();
	}
}