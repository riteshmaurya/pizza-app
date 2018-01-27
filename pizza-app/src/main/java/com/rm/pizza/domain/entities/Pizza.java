package com.rm.pizza.domain.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA")
public class Pizza {

	@Id
	@Column(name="PIZZA_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long pizzaId;
	
	@Column(name="PIZZA_SIZE")
	private String pizzaSize;
	
	@Column(name="PIZZA_BASE")
	private String pizzaBase;
	
	@Column(name="TOPPING_MUSHROOM")
	private Boolean toppingMushroom;
	
	@Column(name="TOPPING_CHICKEN")
	private Boolean toppingChicken;
	
	@Column(name="TOPPING_EXTRACHEESE")
	private Boolean toppingExtracheese;

	@Column(name="TOPPING_MEATBALL")
	private Boolean toppingMeatball;
	
	@Column(name="UNIT_PRICE")
	private BigDecimal unitPrice;
	
	@Column(name="CREATION_DATE")
	private Date creationDate;
	
	
	@Column(name="QUANTITY")
	private Integer quantity;

	public Long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Long pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getPizzaSize() {
		return pizzaSize;
	}

	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public String getPizzaBase() {
		return pizzaBase;
	}

	public void setPizzaBase(String pizzaBase) {
		this.pizzaBase = pizzaBase;
	}

	public Boolean getToppingMushroom() {
		return toppingMushroom;
	}

	public void setToppingMushroom(Boolean toppingMushroom) {
		this.toppingMushroom = toppingMushroom;
	}

	public Boolean getToppingChicken() {
		return toppingChicken;
	}

	public void setToppingChicken(Boolean toppingChicken) {
		this.toppingChicken = toppingChicken;
	}

	public Boolean getToppingExtracheese() {
		return toppingExtracheese;
	}

	public void setToppingExtracheese(Boolean toppingExtracheese) {
		this.toppingExtracheese = toppingExtracheese;
	}

	public Boolean getToppingMeatball() {
		return toppingMeatball;
	}

	public void setToppingMeatball(Boolean toppingMeatball) {
		this.toppingMeatball = toppingMeatball;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Pizza [pizzaId=" + pizzaId + ", pizzaSize=" + pizzaSize + ", pizzaBase=" + pizzaBase
				+ ", toppingMushroom=" + toppingMushroom + ", toppingChicken=" + toppingChicken
				+ ", toppingExtracheese=" + toppingExtracheese + ", toppingMeatball=" + toppingMeatball + ", unitPrice="
				+ unitPrice + ", creationDate=" + creationDate + ", quantity=" + quantity + "]";
	}
}
