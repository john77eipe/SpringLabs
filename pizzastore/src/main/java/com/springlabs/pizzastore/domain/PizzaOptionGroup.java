package com.springlabs.pizzastore.domain;

import javax.persistence.*;

@Entity
@Table(name="tbl_pizza_option_group")
public class PizzaOptionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pizza_id")
    private String pizzaId;

    @Column(name = "option_group_id")
    private String optionGroupId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(String pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getOptionGroupId() {
        return optionGroupId;
    }

    public void setOptionGroupId(String optionGroupId) {
        this.optionGroupId = optionGroupId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PizzaOptionGroup{");
        sb.append("id=").append(id);
        sb.append(", pizzaId='").append(pizzaId).append('\'');
        sb.append(", optionGroupId='").append(optionGroupId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
