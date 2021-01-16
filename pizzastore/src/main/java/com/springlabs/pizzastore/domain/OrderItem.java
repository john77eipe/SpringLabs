package com.springlabs.pizzastore.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name="tbl_order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "pizza_variant_id")
    private Long pizzaVariantId;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPizzaVariantId() {
        return pizzaVariantId;
    }

    public void setPizzaVariantId(Long pizzaVariantId) {
        this.pizzaVariantId = pizzaVariantId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderItem{");
        sb.append("id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", pizzaVariantId=").append(pizzaVariantId);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", quantity=").append(quantity);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append('}');
        return sb.toString();
    }
}