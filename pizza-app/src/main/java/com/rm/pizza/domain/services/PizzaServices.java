package com.rm.pizza.domain.services;

import java.math.BigDecimal;

import com.rm.pizza.domain.entities.Pizza;

public interface PizzaServices {

	BigDecimal calculateTotalPrice(Pizza pizza);
	
	BigDecimal calculatePriceBySize(Pizza pizza);
	BigDecimal calculatePriceByBase(Pizza pizza);
	BigDecimal calculatePriceByToppings(Pizza pizza);
	
}
