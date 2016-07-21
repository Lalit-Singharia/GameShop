package com.niit.gameShop.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gameShop.dao.CategoryDao;
import com.niit.gameShop.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDAO;
	
	public void setCategoryDAO(CategoryDao categoryDAO){
		this.categoryDAO = categoryDAO;
	} 
	
	@Override
	@Transactional
	public List<Category> getAllCategory() {
		return this.categoryDAO.getAllCategory();
	}

	@Override
	@Transactional
	public Category get(String id) {
		return this.categoryDAO.get(id);
	}

	@Override
	@Transactional
	public void delete(String id) {
		this.categoryDAO.delete(id);
	}

	@Override
	@Transactional
	public void addCategory(Category category) {
		this.categoryDAO.addCategory(category);
	}
	
	@Override
	@Transactional
	public Map<String, String> getCategories(){
		List<Category> categoryList = this.categoryDAO.getAllCategory();
		
		Map<String, String> categories = new LinkedHashMap<String, String>();
		
		for (Category category : categoryList) {
			categories.put(category.getId(), category.getName());
		}
		
		return categories;
	}

}
