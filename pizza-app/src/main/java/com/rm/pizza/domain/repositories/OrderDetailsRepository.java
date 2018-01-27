package com.rm.pizza.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rm.pizza.domain.entities.OrderDetails;
import com.rm.pizza.domain.entities.ids.OrderDetailsId;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsId>{
	
}
