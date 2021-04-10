package com.springlabs.pizzastore.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.StringJoiner;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_pizza_variant")
public class PizzaVariant extends BaseEntity {

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
	@JoinColumn(name = "pizza_id", referencedColumnName = "id")
	private Pizza pizza;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="pizzaVariety",
			joinColumns = {
				@JoinColumn(name = "pizza_variant_id")
			},
			inverseJoinColumns = {
				@JoinColumn(name = "pizza_option_id")
			})
	private List<PizzaOption> pizzaOptionList;

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
	@Override
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

}