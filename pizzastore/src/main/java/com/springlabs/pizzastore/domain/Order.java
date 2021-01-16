package com.springlabs.pizzastore.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="tbl_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "shipping_addr_id")
    private Long shippingAddrId;

    @Column(name = "billing_addr_id")
    private Long billingAddrId;

    @Column(name = "order_state")
    //order state gets these other values: 1:'AddingItems', 2:'OrderPlaced', 3:'Shipped', 4:'Delivered'
    private Integer orderState;

    @Column(name = "shipping_cost")
    private BigDecimal shippingCost;

    @Column(name = "shipping_tax")
    private BigDecimal shippingTax;

    @Column(name = "total")
    private BigDecimal total;

    @Transient
    private List<OrderItem> orderItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShippingAddrId() {
        return shippingAddrId;
    }

    public void setShippingAddrId(Long shippingAddrId) {
        this.shippingAddrId = shippingAddrId;
    }

    public Long getBillingAddrId() {
        return billingAddrId;
    }

    public void setBillingAddrId(Long billingAddrId) {
        this.billingAddrId = billingAddrId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public BigDecimal getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(BigDecimal shippingTax) {
        this.shippingTax = shippingTax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", shippingAddrId=").append(shippingAddrId);
        sb.append(", billingAddrId=").append(billingAddrId);
        sb.append(", orderState=").append(orderState);
        sb.append(", shippingCost=").append(shippingCost);
        sb.append(", shippingTax=").append(shippingTax);
        sb.append(", total=").append(total);
        sb.append(", orderItems=").append(orderItems);
        sb.append('}');
        return sb.toString();
    }
}
