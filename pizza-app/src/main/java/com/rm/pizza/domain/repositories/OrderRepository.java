package com.rm.pizza.domain.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rm.pizza.domain.entities.AutoUser;
import com.rm.pizza.domain.entities.OrderMaster;

public interface OrderRepository extends JpaRepository<OrderMaster, Long>{
		List<OrderMaster> findByUser(AutoUser user);
		List<OrderMaster> findAll(Sort sort);
}
