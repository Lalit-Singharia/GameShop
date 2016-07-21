package com.niit.gameShop.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Supplier")
public class Supplier {
	
	@Id
	private String id;
	
	public Supplier() {
		this.id = UUID.randomUUID().toString().substring(24, 32);
	}

	@NotBlank(message="Please enter your name")
	private String name;
	
	@NotBlank(message="Please enter your Address")
	private String Address;
	
	private String contactNumber;
	
	@NotBlank(message="Please enter your email id")
	private String email_Id;

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
