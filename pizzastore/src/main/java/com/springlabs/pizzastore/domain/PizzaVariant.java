package com.springlabs.pizzastore.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name="tbl_pizza_variant")
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

    @Column(name = "on_sale")
    private Integer onsale;

    @ManyToOne
    private Pizza pizza;



}