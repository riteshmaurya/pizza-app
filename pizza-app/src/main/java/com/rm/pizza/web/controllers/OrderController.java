package com.rm.pizza.web.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rm.pizza.domain.entities.AutoUser;
import com.rm.pizza.domain.entities.OrderMaster;
import com.rm.pizza.domain.entities.Pizza;
import com.rm.pizza.domain.repositories.AutoUserRepository;
import com.rm.pizza.domain.repositories.OrderRepository;
import com.rm.pizza.domain.repositories.PizzaRepository;
import com.rm.pizza.domain.services.OrderServices;
import com.rm.pizza.domain.services.PizzaServices;


@Controller
@RequestMapping("/selectOrder")
@SuppressWarnings("serial")
public class OrderController {
	
	@Autowired
	private AutoUserRepository autoUserRepository;

	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired
	private PizzaServices pizzaServices;
	
	@Autowired
	private OrderServices orderServices;

	private Pizza pizza = new Pizza();
	
	@RequestMapping(value="/add",method=RequestMethod.GET )
	public String addPizzaOrder(Model model) {
		model.addAttribute("pizza", new Pizza());
		return "orderPizza";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String confirmPizzaOrder(@ModelAttribute Pizza pizza, Model model) {
		model.addAttribute("pricePerPizza", pizzaServices.calculateTotalPrice(pizza));
		model.addAttribute("totalPrice", pizzaServices
					.calculateTotalPrice(pizza).multiply(BigDecimal.valueOf(pizza.getQuantity())));
		this.pizza = pizza;
		return "confirmOrder";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savePizzaOrder(@ModelAttribute Pizza pizza, Model model, Authentication auth){
		AutoUser  user = (AutoUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//AutoUser user = this.autoUserRepository.findByUsername(username);

		orderServices.createOrder(this.pizza, user);
		
		
		if(auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
			model.addAttribute("orders", orderRepository.findAll(new Sort("status")));
			
		}else{ 
			model.addAttribute("orders", orderRepository.findByUser((AutoUser)auth.getPrincipal()));
		}
		return "orders";
	}
	
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

	
	@ModelAttribute("getPizzaSize")
	public List<String> getPizzaSize() {
		return new ArrayList<String>(){{
			add("Small");
			add("Medium");
			add("Large");
		}};
	}
	
	@ModelAttribute("getPizzaBase")
	public List<String> getPizzaBase() {
		return new ArrayList<String>(){{
			add("Thin");
			add("Thick");
		}};
	}
	

	
	@ModelAttribute("getPizzaQuantity")
	public List<Integer> getPizzaQuantity() {
		return new ArrayList<Integer>(){{
			add(1);
			add(2);
			add(3);
			add(4);
		}};
	}
	
	@ModelAttribute("item")
	public String getItemName() {
		return "Pizza";
	}
	
	
}