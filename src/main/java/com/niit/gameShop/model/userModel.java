package com.niit.gameShop.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "USER_DETAIL")
public class userModel {
	
	@Id
	@Column(name="ID")
	private String id;
	
	public userModel() {
		this.id = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}
	
	@NotBlank(message ="Please enter your Name")
	private String name;
	
	private String contactNumber;
	
	@NotBlank(message="Please enter your Email Id")
	private String email_Id;
	
	private String password;
	
	private String CartId;
	
	@Transient
	private String confirmPassword;
	
	public String getCartId() {
		return CartId;
	}

	public void setCartId(String cartId) {
		CartId = cartId;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "userModel [id=" + id + ", name=" + name + ", contactNumber=" + contactNumber + ", email_Id=" + email_Id
				+ ", password=" + password + ", CartId=" + CartId + ", confirmPassword=" + confirmPassword + "]";
	}
	
	

}
