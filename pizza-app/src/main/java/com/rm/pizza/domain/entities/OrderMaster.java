package com.rm.pizza.domain.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rm.pizza.domain.constants.PizzaConstants;

@Entity
@Table(name="ORDER_MASTER")
public class OrderMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@Column(name="ORDER_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
		
	@Column(name="TOTAL_ITEMS")
	private Integer totalItems;
	
	@Column(name="STATUS")
	@Enumerated(EnumType.STRING)
	private PizzaConstants.OrderStatus status;
	
	@Column(name="TOTAL_PRICE")
	private BigDecimal totalPrice;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private AutoUser user;
	
	@Column(name="DELIVERY_ADDRESS")
	private String deliveryAddress;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="ORDER_PIZZA", joinColumns=@JoinColumn(name="ORDER_ID"), 
		inverseJoinColumns=@JoinColumn(name="PIZZA_ID"))
	private List<Pizza> pizzas = new ArrayList<>();

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public PizzaConstants.OrderStatus getStatus() {
		return status;
	}

	public void setStatus(PizzaConstants.OrderStatus status) {
		this.status = status;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public AutoUser getUser() {
		return user;
	}

	public void setUser(AutoUser user) {
		this.user = user;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderMaster [orderId=" + orderId + ", orderDate=" + orderDate + ", totalItems=" + totalItems
				+ ", status=" + status + ", totalPrice=" + totalPrice + ", user=" + user + ", deliveryAddress="
				+ deliveryAddress + ", pizzas=" + pizzas + "]";
	}
}
