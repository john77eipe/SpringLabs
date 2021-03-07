package com.springlabs.pizzastore.domain;

import java.math.BigDecimal;
import java.util.List;
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
	private Integer onsale;
	
	@ManyToOne
	@JoinColumn(name = "pizza_id")
	private Pizza pizza;

	@OneToMany
	@JoinColumn(name = "id_pizza_variety")
	private List<PizzaVariety> pizzaVariety;

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

	public Integer getOnsale() {
		return onsale;
	}

	public void setOnsale(Integer onsale) {
		this.onsale = onsale;
	}

	public Pizza getPizza() {
		return pizza;
	}
	
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PizzaVariant [id=");
		builder.append(id);
		builder.append(", sku=");
		builder.append(sku);
		builder.append(", price=");
		builder.append(price);
		builder.append(", priceWithTax=");
		builder.append(priceWithTax);
		builder.append(", quantityOnHand=");
		builder.append(quantityOnHand);
		builder.append(", outOfStockThreshold=");
		builder.append(outOfStockThreshold);
		builder.append(", tax=");
		builder.append(tax);
		builder.append(", onsale=");
		builder.append(onsale);
		builder.append(", pizza=");
		builder.append(pizza);
		builder.append(", pizzaVariety=");
		builder.append(pizzaVariety);
		builder.append("]");
		return builder.toString();
	}

}