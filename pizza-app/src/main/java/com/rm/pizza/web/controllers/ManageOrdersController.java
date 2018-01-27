package com.rm.pizza.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rm.pizza.domain.entities.AutoUser;
import com.rm.pizza.domain.entities.OrderMaster;
import com.rm.pizza.domain.repositories.AutoUserRepository;
import com.rm.pizza.domain.repositories.OrderRepository;
import com.rm.pizza.domain.repositories.PizzaRepository;
import com.rm.pizza.domain.services.OrderServices;

@Controller

@RequestMapping("/order")
public class ManageOrdersController {

	@Autowired
	private AutoUserRepository autoUserRepository;

	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired
	private OrderServices orderServices;
	
	private OrderMaster  order;
	
	@RequestMapping(value={"/findAll","/back"}, method=RequestMethod.GET)
	public String findAllPizzaOrder(@ModelAttribute("order") OrderMaster order, Model model, Authentication auth){
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
			model.addAttribute("orders", orderRepository.findAll(new Sort("orderDate")));
		}else{ 
			model.addAttribute("orders", orderRepository.findByUser((AutoUser)auth.getPrincipal()));
		}
			
		model.addAttribute("order", order);
		return "orders";
	}


	@RequestMapping("/{orderId}")
	public String getPizzaOrder(@PathVariable("orderId") Long orderId, Model model){
		OrderMaster order = orderRepository.findOne(orderId);
		this.order = order;
		model.addAttribute("order", this.order);
		return "order";
	}

	@RequestMapping("/item/{orderId}")
	public String getOrderDetails(@PathVariable("orderId") Long orderId, Model model){
		OrderMaster order = orderRepository.findOne(orderId);
		this.order = order;
		
		model.addAttribute("pizzas", order.getPizzas());
		return "itemDetails";
	}


	
	@RequestMapping(value="/cancel")
	public String cancelPizzaOrder(@ModelAttribute("order") OrderMaster order, Model model){
		orderServices.cancelOrder(this.order);
		model.addAttribute("orders", orderRepository.findAll(new Sort("orderDate")));
		return "orders";
	}
	
	@RequestMapping(value="/process")
	public String processPizzaOrder(@ModelAttribute("order") OrderMaster order, Model model){
		orderServices.processOrder(this.order);
		model.addAttribute("orders", orderRepository.findAll(new Sort("orderDate")));
		return "orders";
	}
	
	@RequestMapping(value="/complete")
	public String completePizzaOrder(@ModelAttribute("order") OrderMaster order, Model model){
		orderServices.completeOrder(this.order);
		model.addAttribute("orders", orderRepository.findAll(new Sort("orderDate")));
		return "orders";
	}
	
	@ModelAttribute("item")
	public String getItemName() {
		return "Pizza";
	}
}
