package com.rm.pizza.domain.services;

import com.rm.pizza.domain.entities.AutoUser;
import com.rm.pizza.domain.entities.OrderMaster;
import com.rm.pizza.domain.entities.Pizza;

public interface OrderServices {
	
	OrderMaster createOrder(Pizza order, AutoUser user);
	
	void cancelOrder(OrderMaster order);
	
	void processOrder(OrderMaster order);
	
	void completeOrder(OrderMaster order);
	
	
}
