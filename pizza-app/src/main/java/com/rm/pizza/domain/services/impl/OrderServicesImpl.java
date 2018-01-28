package com.rm.pizza.domain.services.impl;

import java.math.BigDecimal;
import java.util.Date;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rm.pizza.domain.constants.PizzaConstants;
import com.rm.pizza.domain.constants.PizzaConstants.OrderStatus;
import com.rm.pizza.domain.entities.AutoUser;
import com.rm.pizza.domain.entities.OrderMaster;
import com.rm.pizza.domain.entities.Pizza;
import com.rm.pizza.domain.repositories.AutoUserRepository;
import com.rm.pizza.domain.repositories.OrderRepository;
import com.rm.pizza.domain.repositories.PizzaRepository;
import com.rm.pizza.domain.services.OrderServices;

@Service("orderServices")
public class OrderServicesImpl implements OrderServices {
	
	@Autowired
	private AutoUserRepository autoUserRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PizzaRepository pizzaRepository;

	@Override
	@Transactional
	public OrderMaster createOrder(Pizza pizza, AutoUser user) {
		OrderMaster order = new OrderMaster();
		order.setOrderDate(new Date());
		order.getPizzas().add(pizza);
		order.setStatus(PizzaConstants.OrderStatus.CREATED);
		order.setTotalItems(pizza.getQuantity());
		order.setDeliveryAddress(user.getDeliveryAddress());
		order.setTotalPrice(pizza.getUnitPrice().multiply(BigDecimal.valueOf(pizza.getQuantity())));
		order.setUser(user);
		
		orderRepository.saveAndFlush(order);
		
		return order;
	}

	@Override
	@Transactional
	public void cancelOrder(OrderMaster order) {
		
		order.setStatus(OrderStatus.CANCEL);
		orderRepository.saveAndFlush(order);
	}

	@Override
	@Transactional
	public void completeOrder(OrderMaster order) {
		order.setStatus(OrderStatus.COMPLETED);
		orderRepository.saveAndFlush(order);
		
	}

	@Override
	@Transactional
	public void processOrder(OrderMaster order) {
		order.setStatus(OrderStatus.PROCESSING);
		orderRepository.saveAndFlush(order);	
		
	}


}
