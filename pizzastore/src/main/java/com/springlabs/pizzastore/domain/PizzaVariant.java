package com.springlabs.pizzastore.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_pizza_variant")
public class PizzaVariant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "sku")
	private String sku;

	@Column(name = "price")
	private BigDecimal price;

	@Transient
	private BigDecimal priceWithTax;

	@Column(name = "qty_on_hand")
	private Long quantityOnHand;

	@Column(name = "out_of_stock_limit")
	private Long outOfStockThreshold;

	@Column(name = "tax")
	private BigDecimal tax;

	@Column(name = "qty_on_sale")
	private Integer quantityOnSale;
	
	@ManyToOne
	@JoinColumn(name = "pizza_id")
	private Pizza pizza;

	@OneToMany
	@JoinColumn(name = "pizza_variety_id")
	private List<PizzaVariety> pizzaVariety;

	public PizzaVariant() {
	}

	public PizzaVariant(@NotNull String sku, BigDecimal price, Long quantityOnHand, Long outOfStockThreshold, BigDecimal tax, Integer quantityOnSale, Pizza pizza) {
		this.sku = sku;
		this.price = price;
		this.quantityOnHand = quantityOnHand;
		this.outOfStockThreshold = outOfStockThreshold;
		this.tax = tax;
		this.quantityOnSale = quantityOnSale;
		this.pizza = pizza;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceWithTax() {
		return price.add(tax);
	}

	public void setPriceWithTax(BigDecimal priceWithTax) {
		this.priceWithTax = priceWithTax;
	}

	public Long getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(Long quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public Long getOutOfStockThreshold() {
		return outOfStockThreshold;
	}

	public void setOutOfStockThreshold(Long outOfStockThreshold) {
		this.outOfStockThreshold = outOfStockThreshold;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public Integer getQuantityOnSale() {
		return quantityOnSale;
	}

	public void setQuantityOnSale(Integer quantityOnSale) {
		this.quantityOnSale = quantityOnSale;
	}

	public Pizza getPizza() {
		return pizza;
	}
	
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public List<PizzaVariety> getPizzaVariety() {
		return pizzaVariety;
	}

	public void setPizzaVariety(List<PizzaVariety> pizzaVariety) {
		this.pizzaVariety = pizzaVariety;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", PizzaVariant.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("sku='" + sku + "'")
				.add("price=" + price)
				.add("priceWithTax=" + priceWithTax)
				.add("quantityOnHand=" + quantityOnHand)
				.add("outOfStockThreshold=" + outOfStockThreshold)
				.add("tax=" + tax)
				.add("quantityOnSale=" + quantityOnSale)
				.add("pizza=" + pizza)
				.add("pizzaVariety=" + pizzaVariety)
				.toString();
	}

}