package com.rm.pizza.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rm.pizza.domain.entities.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{
	
}
