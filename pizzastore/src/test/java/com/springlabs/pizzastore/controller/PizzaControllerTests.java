package com.springlabs.pizzastore.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;


import java.math.BigDecimal;

@WebMvcTest(PizzaController.class)
public class PizzaControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PizzaService pizzaService;

    @BeforeEach
    void setup() {
        Pizza pizza1 = new Pizza();
        pizza1.setId(1L);
        pizza1.setName("test pizza 1");
        Pizza pizza2 = new Pizza();
        pizza2.setId(1L);
        pizza2.setName("test pizza 2");
        //given(this.pizzaService.getAllPizzas()).willReturn(pizza1));
    }

    @Test
    void testPizzaListHtml() throws Exception {
        mockMvc.perform(get("/pizza/all"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("pizzaService"))
                .andExpect(view().name("pizza/pizzaList"));
    }

}
