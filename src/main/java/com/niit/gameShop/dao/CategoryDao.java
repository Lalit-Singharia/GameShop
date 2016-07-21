package com.niit.gameShop.dao;

import java.util.List;

import com.niit.gameShop.model.Category;

public interface CategoryDao {
	
	public List<Category> getAllCategory();

	public Category get(String id);

	public void delete(String id);
	
	public void addCategory(Category category);

}
