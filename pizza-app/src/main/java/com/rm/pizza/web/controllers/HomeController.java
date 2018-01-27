package com.rm.pizza.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rm.pizza.domain.entities.AutoUser;
import com.rm.pizza.domain.repositories.AutoUserRepository;
import com.rm.pizza.domain.repositories.OrderRepository;
import com.rm.pizza.domain.repositories.PizzaRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private AutoUserRepository autoUserRepository;

	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute AutoUser user) {
		
		user.setRole("ROLE_USER");
		autoUserRepository.save(user);
		
		Authentication auth = new UsernamePasswordAuthenticationToken(user, 
					 user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
		return "redirect:/";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String goRegister() {
		return "register";
	}

	@RequestMapping(method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String goLogin(){
		return "login";
	}
	
}
