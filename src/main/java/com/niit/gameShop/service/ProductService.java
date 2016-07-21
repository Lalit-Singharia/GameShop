package com.niit.gameShop.service;

import java.util.List;
import java.util.Map;

import com.niit.gameShop.model.Product;

public interface ProductService {
	
public List<Product> getAllProduct();
	
	public Product get(String id);
	
	public Product getProductName(String name);
	
	public void delete(String id);
	
	public void addProduct(Product product);
	
	public Map<String, String> getProduct();
}
