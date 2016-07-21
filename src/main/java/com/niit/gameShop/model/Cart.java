package com.niit.gameShop.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart {
	
	@Id
	private String id; 
	
	public Cart() {
		this.id = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

	private String userId;
	
	private Integer count;
	
	private double grandTotal;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", count=" + count + ", grandTotal=" + grandTotal + "]";
	}
	
	

}
