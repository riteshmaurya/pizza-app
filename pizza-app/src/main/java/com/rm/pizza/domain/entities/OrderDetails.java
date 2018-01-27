package com.rm.pizza.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.rm.pizza.domain.entities.ids.OrderDetailsId;

@Entity
@Table(name="ORDER_PIZZA")
@IdClass(OrderDetailsId.class)
public class OrderDetails {

	@Id
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@Id
	@Column(name="PIZZA_ID")
	private Long pizzaId;
	


	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Long pizzaId) {
		this.pizzaId = pizzaId;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", pizzaId=" + pizzaId + "]";
	}	
}
