package com.springlabs.pizzastore.domain;

import javax.persistence.*;
import java.util.StringJoiner;

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
        return new StringJoiner(", ", PizzaOptionGroup.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("pizza=" + pizza)
                .add("optionGroup=" + optionGroup)
                .toString();
    }
}
