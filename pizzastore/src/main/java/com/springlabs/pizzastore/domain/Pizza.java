package com.springlabs.pizzastore.domain;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="tbl_pizza")
public class Pizza {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

    @NotNull
    @Size(min = 2)
    @Column(name = "`name`")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "`desc`")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "category_default")
    private Category category;

	@OneToMany
    private PizzaVariant pizzaVariant;
    

    @Transient
    private List<Category> secondaryCategories;


    
    public Pizza() {
	}
	
    public Pizza(String name, String description, BigDecimal price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Pizza(String name, String description, BigDecimal price, Category category, Long quantity, BigDecimal tax) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}
	
	
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

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Category> getSecondaryCategories() {
		return secondaryCategories;
	}

	public void setSecondaryCategories(List<Category> secondaryCategories) {
		this.secondaryCategories = secondaryCategories;
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
		builder.append(", secondaryCategories=");
		builder.append(secondaryCategories);
		builder.append("]");
		return builder.toString();
	}


}