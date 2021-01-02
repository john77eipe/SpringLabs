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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "shipping_addr_id")
    private Long shippingAddrId;

    @ManyToOne
    @JoinColumn(name = "billing_addr_id")
    private Long billingAddrId;

    @ManyToOne
    @JoinColumn(name = "order_state")
    //order state gets these other values: 1:'AddingItems', 2:'OrderPlaced', 3:'Shipped', 4:'Delivered'
    private Integer orderState;

    @ManyToOne
    @JoinColumn(name = "shipping_cost")
    private BigDecimal shippingCost;

    @ManyToOne
    @JoinColumn(name = "shipping_tax")
    private BigDecimal shippingTax;

    @Column(name = "total")
    private BigDecimal total;

    @Transient
    private List<OrderItem> orderItems;

}
