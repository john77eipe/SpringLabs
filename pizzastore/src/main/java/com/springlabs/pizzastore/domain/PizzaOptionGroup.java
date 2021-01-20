package com.springlabs.pizzastore.domain;

import javax.persistence.*;

@Entity
@Table(name="tbl_pizza_option_group")
public class PizzaOptionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
	private Pizza pizza;
    
    @ManyToOne
    @JoinColumn(name = "option_group_id")
	private OptionGroup optionGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PizzaOptionGroup{");
        sb.append("id=").append(id);
        sb.append(", pizzaId='").append(pizza).append('\'');
        sb.append(", optionGroupId='").append(optionGroup).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
