package com.niit.gameShop.dao;

import java.util.List;

import com.niit.gameShop.model.Product;

public interface ProductDao {
	
	public List<Product> getAllProduct();
	
	public Product get(String id);
	
	public Product getProductName(String name);
	
	public void delete(String id);
	
	public void addProduct(Product product);

}
