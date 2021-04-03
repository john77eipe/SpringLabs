package com.springlabs.pizzastore.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name="tbl_order")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "shipping_addr_id")
    private Address shippingAddr;

    @ManyToOne
    @JoinColumn(name = "billing_addr_id")
    private Address billingAddr;

    @Column(name = "order_state")
    //order state gets these other values: 1:'AddingItems', 2:'OrderPlaced', 3:'Shipped', 4:'Delivered'
    private Integer orderState;

    @Column(name = "shipping_cost")
    private BigDecimal shippingCost;

    @Column(name = "shipping_tax")
    private BigDecimal shippingTax;

    @Column(name = "total")
    private BigDecimal total;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

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

    public Address getShippingAddr() {
        return shippingAddr;
    }

    public void setShippingAddr(Address shippingAddr) {
        this.shippingAddr = shippingAddr;
    }

    public Address getBillingAddr() {
        return billingAddr;
    }

    public void setBillingAddr(Address billingAddr) {
        this.billingAddr = billingAddr;
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
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userId=" + userId)
                .add("shippingAddr=" + shippingAddr)
                .add("billingAddr=" + billingAddr)
                .add("orderState=" + orderState)
                .add("shippingCost=" + shippingCost)
                .add("shippingTax=" + shippingTax)
                .add("total=" + total)
                .add("orderItems=" + orderItems)
                .toString();
    }
}
