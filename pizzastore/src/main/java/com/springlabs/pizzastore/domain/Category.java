package com.springlabs.pizzastore.domain;

import javax.persistence.*;
import java.util.StringJoiner;


@Entity
@Table(name="tbl_category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "category")
	private String category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Category.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("category='" + category + "'")
				.toString();
	}

}
