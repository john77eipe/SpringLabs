package com.springlabs.pizzastore.service.impl;

import java.util.List;

import com.springlabs.pizzastore.domain.PizzaOption;
import com.springlabs.pizzastore.domain.PizzaVariety;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.domain.PizzaVariant;
import com.springlabs.pizzastore.repository.impl.JpaPizzaRepository;
import com.springlabs.pizzastore.repository.impl.JpaPizzaVariantRepository;
import com.springlabs.pizzastore.service.PizzaService;


@Service("pizzaService")
public class PizzaServiceImpl implements PizzaService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JpaPizzaRepository pizzaRepository;
    
    @Autowired
    private JpaPizzaVariantRepository jpaPizzaVariantRepository;

    public PizzaServiceImpl(JpaPizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }


    @Override
    public List<Pizza> getAllPizzas() {
        logger.debug("Begin operation: findAllPizzas ");
        List<Pizza> pizzaList = pizzaRepository.findAll();

        logger.debug("End operation: findAllPizzas: response:{} ", pizzaList);
        return pizzaList;
    }

    @Override
    public Pizza savePizza(final Pizza pizza) {
        logger.debug("Begin operation: savePizza: request:{} ", pizza);
        Pizza pizzaSaved = pizzaRepository.save(pizza);
        logger.debug("End operation: savePizza: response:{} ", pizza);
        return pizzaSaved;
    }


	@Override
	public Pizza getPizza(long pizzaId) {
		logger.debug("Begin operation: getPizza: request:{} ", pizzaId);
        Pizza pizza = pizzaRepository.getOne(pizzaId);
        //List<Category> otherCategories = pizzaCategoryRepository.fetchSecondaryPizzaCategories(pizzaId);
        //logger.debug("Fetched non-default categories: "+otherCategories);
        //pizza.setSecondaryCategories(otherCategories);
        logger.debug("End operation: getPizza: response:{} ", pizza);
		return pizza;
	}
	
	@Override
	public PizzaVariant getPizzaVariant(Long pizzaVariantId) {
		logger.debug("getPizzaVariant pizzaVariantId = ", pizzaVariantId);
		PizzaVariant pizzaVariant = jpaPizzaVariantRepository.getOne(pizzaVariantId);
		logger.debug("pizzaVariant = ", pizzaVariant);
		return pizzaVariant;
	}
	
	@Override
	public List<PizzaVariant> getAllPizzaVariants(){
		logger.debug("findAllPizzaVariant");
		return jpaPizzaVariantRepository.findAll();
	}

    @Override
    public PizzaVariant savePizzaVariant(PizzaVariant pizza) {
        return null;
    }

    @Override
    public PizzaOption savePizzaOption(PizzaOption pizzaOption) {
        return null;
    }

    @Override
    public PizzaVariety savePizzaVariety(PizzaOption pizzaOption, Long pizzaVariantId) {
        return null;
    }

}