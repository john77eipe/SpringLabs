package com.springlabs.pizzastore.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="pizza")
public class Pizza {
	
	public Pizza() {
	}
	
    public Pizza(String pizza_name, String pizza_desc, String pizza_price) {
		name = pizza_name;
		description = pizza_desc;
		price = Float.valueOf(pizza_price);
	}
	
	public Pizza(String pizza_name, String pizza_desc, String pizza_price, PizzaCategory existing_pizzaCategory) {
		name = pizza_name;
		description = pizza_desc;
		price = Float.valueOf(pizza_price);
		category = existing_pizzaCategory;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

    @NotNull
    @Size(min = 2)
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Float price;

    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "category")
    private PizzaCategory category;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PizzaCategory getCategory() {
		return category;
	}

	public void setCategory(PizzaCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pizza [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", description=");
		builder.append(description);
		builder.append(", category=");
		builder.append(category);
		builder.append("]");
		return builder.toString();
	}
}