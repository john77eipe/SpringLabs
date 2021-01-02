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

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "pizza_variant_id")
    private Long pizzaVariantId;

    @ManyToOne
    @JoinColumn(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

}