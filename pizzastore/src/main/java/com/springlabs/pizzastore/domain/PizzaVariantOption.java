package com.springlabs.pizzastore.domain;

import javax.persistence.*;

@Entity
@Table(name="tbl_pizza_variant_option_map")
public class PizzaVariantOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pizza_variant_id")
    private PizzaVariant pizzaVariant;

    @ManyToOne
    @JoinColumn(name = "pizza_option_id")
    private Option option;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PizzaVariant getPizzaVariant() {
		return pizzaVariant;
	}

	public void setPizzaVariant(PizzaVariant pizzaVariant) {
		this.pizzaVariant = pizzaVariant;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PizzaVariantOption{");
        sb.append("id=").append(id);
        sb.append(", pizzaVariantId=").append(pizzaVariant);
        sb.append(", pizzaOptionId=").append(option);
        sb.append('}');
        return sb.toString();
    }
}