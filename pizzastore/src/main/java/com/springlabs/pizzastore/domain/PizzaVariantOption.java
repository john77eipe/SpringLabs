package com.springlabs.pizzastore.domain;

import javax.persistence.*;

@Entity
@Table(name="tbl_pizza_variant_option_map")
public class PizzaVariantOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pizza_variant_id")
    private Long pizzaVariantId;

    @Column(name = "pizza_option_id")
    private Long pizzaOptionId;

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

    public Long getPizzaOptionId() {
        return pizzaOptionId;
    }

    public void setPizzaOptionId(Long pizzaOptionId) {
        this.pizzaOptionId = pizzaOptionId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PizzaVariantOption{");
        sb.append("id=").append(id);
        sb.append(", pizzaVariantId=").append(pizzaVariantId);
        sb.append(", pizzaOptionId=").append(pizzaOptionId);
        sb.append('}');
        return sb.toString();
    }
}
