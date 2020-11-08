package com.springlabs.pizzastore.service;

import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.repository.PizzaRepository;
import com.springlabs.pizzastore.repository.impl.JpaPizzaRepository;
import com.springlabs.pizzastore.service.impl.PizzaServiceImpl;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class PizzaServiceTests {

    @Autowired
    protected PizzaServiceImpl pizzaService;

    @Test
    void shouldFindPizzaById() {
        Pizza pizza = this.pizzaService.getPizza(1);
        assertThat(pizza).isNotNull();
        assertThat(pizza.getId()).isEqualTo(1L);
    }
}
