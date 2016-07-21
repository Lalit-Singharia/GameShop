package com.niit.gameShop.service;

import java.util.List;
import java.util.Map;

import com.niit.gameShop.model.Category;

public interface CategoryService {
	
	public List<Category> getAllCategory();

	public Category get(String id);

	public void delete(String id);
	
	public void addCategory(Category category);
	
	public Map<String, String> getCategories();

}
