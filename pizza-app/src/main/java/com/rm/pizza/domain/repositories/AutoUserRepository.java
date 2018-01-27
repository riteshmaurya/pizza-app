package com.rm.pizza.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rm.pizza.domain.entities.AutoUser;

public interface AutoUserRepository extends JpaRepository<AutoUser, Long> {

	public AutoUser findByUsername(String username);
}
