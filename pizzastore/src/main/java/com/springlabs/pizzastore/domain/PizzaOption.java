package com.springlabs.pizzastore.domain;

import javax.persistence.*;

@Entity
@Table(name="tbl_pizza_option")
public class PizzaOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza_option")
    private Long id;

    @Column(name = "option_type")
    private String optionType;

    @Column(name = "option_value")
    private String optionValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PizzaOption [id=");
		builder.append(id);
		builder.append(", optionType=");
		builder.append(optionType);
		builder.append(", optionValue=");
		builder.append(optionValue);
		builder.append("]");
		return builder.toString();
	}
    
}