package com.niit.gameShop.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	private String id;
	
	public Category() {
		this.id = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}

	@NotBlank(message ="please enter name of the item")
	private String name;
	
	@NotBlank(message="Please enter the description of the product")
	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
