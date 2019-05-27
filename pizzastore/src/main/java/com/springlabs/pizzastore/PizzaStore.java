package com.springlabs.pizzastore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

/**
 * I don't have a component scan because the main class is at a top level package 
 * directory and spring boot automatically scans all packages and classes under it.
 * If the main class is at a different package then this is needed.
 * @ComponentScan("com.springlabs.pizzastore")
 * @author johne
 *
 */
public class PizzaStore {
	
	public static void main(String[] args) {
		SpringApplication.run(PizzaStore.class, args);

	}

}
