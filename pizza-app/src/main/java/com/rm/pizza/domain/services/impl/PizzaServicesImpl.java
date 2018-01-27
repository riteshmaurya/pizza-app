package com.rm.pizza.domain.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm.pizza.domain.constants.PizzaConstants;
import com.rm.pizza.domain.entities.Pizza;
import com.rm.pizza.domain.repositories.AutoUserRepository;
import com.rm.pizza.domain.repositories.OrderRepository;
import com.rm.pizza.domain.repositories.PizzaRepository;
import com.rm.pizza.domain.services.PizzaServices;

@Service("pizzaServices")
public class PizzaServicesImpl implements PizzaServices {
	
	@Autowired
	private AutoUserRepository autoUserRepository;

	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Override
	public BigDecimal calculatePriceBySize(Pizza pizza) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		//Price calculation based on pizza size
		if (pizza.getPizzaSize().equalsIgnoreCase(PizzaConstants.PizzaSize.SMALL.toString())) {
			totalPrice = totalPrice.add(PizzaConstants.PizzaSize.SMALL.price);
		} if (pizza.getPizzaSize().equalsIgnoreCase(PizzaConstants.PizzaSize.MEDIUM.toString())) {
			totalPrice = totalPrice.add(PizzaConstants.PizzaSize.MEDIUM.price);
		}if (pizza.getPizzaSize().equalsIgnoreCase(PizzaConstants.PizzaSize.LARGE.toString())) {
			totalPrice = totalPrice.add(PizzaConstants.PizzaSize.LARGE.price);
		} /*else {
			totalPrice = PizzaConstants.pizzaSizeMinPrice;
		}*/
		//Price calculation based on pizza size
		System.out.println("calculatePriceBySize: "+totalPrice);
		return totalPrice;
	}

	@Override
	public BigDecimal calculateTotalPrice(Pizza pizza) {
		BigDecimal totalPrice = BigDecimal.ZERO;
	
		totalPrice = totalPrice.add(calculatePriceBySize(pizza))
						.add(calculatePriceByBase(pizza).add(calculatePriceByToppings(pizza)));
		pizza.setUnitPrice(totalPrice);
		//totalPrice = totalPrice.multiply(BigDecimal.valueOf(pizza.getQuantity()));
		System.out.println("calculateTotalPrice: "+totalPrice);
		return totalPrice;
	}

	@Override
	public BigDecimal calculatePriceByBase(Pizza pizza) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		if(pizza.getPizzaBase().equalsIgnoreCase(PizzaConstants.PizzaBase.THIN.toString())) {
			totalPrice = totalPrice.add(PizzaConstants.PizzaBase.THIN.price);
		} if(pizza.getPizzaBase().equalsIgnoreCase(PizzaConstants.PizzaBase.THICK.toString())) {
			totalPrice = totalPrice.add(PizzaConstants.PizzaBase.THICK.price);
		} /*else {
			totalPrice = PizzaConstants.pizzaSizeMinPrice;
		}*/
		System.out.println("calculatePriceByBase: "+totalPrice);
		return totalPrice;
	}

	@Override
	public BigDecimal calculatePriceByToppings(Pizza pizza) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		if(pizza.getToppingChicken()) {
			totalPrice = totalPrice.add(PizzaConstants.PizzaToppings.TOPPING_CHICKEN.price);
		}if(pizza.getToppingExtracheese()) {
			totalPrice = totalPrice.add(PizzaConstants.PizzaToppings.TOPPING_EXTRACHEESE.price);
		}if(pizza.getToppingMeatball()) {
			totalPrice = totalPrice.add(PizzaConstants.PizzaToppings.TOPPING_MEATBALL.price);
		}if(pizza.getToppingMushroom()) {
			totalPrice = totalPrice.add(PizzaConstants.PizzaToppings.TOPPING_MUSHROOM.price);
		}
		System.out.println("calculatePriceByToppings: "+totalPrice);
		return totalPrice;
	}

}
