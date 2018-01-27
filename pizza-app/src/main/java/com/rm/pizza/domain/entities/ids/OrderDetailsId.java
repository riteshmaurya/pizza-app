package com.rm.pizza.domain.entities.ids;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderDetailsId implements Serializable{	
	
	private Long orderId;
	
	private Long pizzaId;
	
	public OrderDetailsId(Long orderId, Long pizzaId) {
		super();
		this.orderId = orderId;
		this.pizzaId = pizzaId;
	}

	public OrderDetailsId() {

	}

	public Long getPizzaId() {
		return pizzaId;
	}

	public Long getOrderId() {
		return orderId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((pizzaId == null) ? 0 : pizzaId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailsId other = (OrderDetailsId) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (pizzaId == null) {
			if (other.pizzaId != null)
				return false;
		} else if (!pizzaId.equals(other.pizzaId))
			return false;
		return true;
	}



	
	
	
}
