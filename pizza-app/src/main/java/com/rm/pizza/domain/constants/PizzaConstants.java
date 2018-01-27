package com.rm.pizza.domain.constants;

import java.math.BigDecimal;

public final class PizzaConstants {
	
	public static final BigDecimal pizzaSizeMinPrice = BigDecimal.valueOf(999999.00);
	
	public static final BigDecimal pizzaCrustMinPrice = BigDecimal.valueOf(999999.00);
	
	
	public enum PizzaSize {
		SMALL(BigDecimal.valueOf(5.00)), MEDIUM(BigDecimal.valueOf(10.00)), LARGE(BigDecimal.valueOf(15.00));
		
		public BigDecimal price;
		PizzaSize(BigDecimal price){
			this.price = price;
		}
	}
	
	public enum PizzaBase{
		THIN(BigDecimal.valueOf(5.00)), THICK(BigDecimal.valueOf(5.00));
		
		public BigDecimal price;
		PizzaBase(BigDecimal price){
			this.price = price;
		}
		
	}
	
	public enum PizzaToppings{
		TOPPING_MUSHROOM(BigDecimal.valueOf(5.00)), TOPPING_CHICKEN(BigDecimal.valueOf(5.00)), 
			TOPPING_EXTRACHEESE(BigDecimal.valueOf(5.00)), TOPPING_MEATBALL(BigDecimal.valueOf(5.00));
		
		public BigDecimal price;
		PizzaToppings(BigDecimal price){
			this.price = price;
		}
		
	}
	
	public enum OrderStatus{
		CREATED, CANCEL, PROCESSING, COMPLETED
	}
	
}
