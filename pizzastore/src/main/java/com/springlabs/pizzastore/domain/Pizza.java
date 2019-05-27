package com.springlabs.pizzastore.domain;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class Pizza {

    @NotNull
    @Size(min = 2)
    private String name;

    private Float price;

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

    @Override
	public String toString() {
		return "Pizza [name=" + name + ", price=" + price + "]";
	}
}