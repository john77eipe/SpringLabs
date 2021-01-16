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

    @Column(name = "pizza_id")
    private Long pizzaId;

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
        return priceWithTax;
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

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PizzaVariant{");
        sb.append("id=").append(id);
        sb.append(", sku='").append(sku).append('\'');
        sb.append(", price=").append(price);
        sb.append(", priceWithTax=").append(priceWithTax);
        sb.append(", quantityOnHand=").append(quantityOnHand);
        sb.append(", outOfStockThreshold=").append(outOfStockThreshold);
        sb.append(", tax=").append(tax);
        sb.append(", onsale=").append(onsale);
        sb.append(", pizzaId=").append(pizzaId);
        sb.append('}');
        return sb.toString();
    }
}