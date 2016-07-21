package com.niit.gameShop.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gameShop.dao.ProductDao;
import com.niit.gameShop.model.Category;
import com.niit.gameShop.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDAO;
	
	public void setProductDAO(ProductDao productDAO){
		this.productDAO = productDAO;
	}
	
	@Override
	@Transactional
	public List<Product> getAllProduct() {
		return this.productDAO.getAllProduct();
	}

	@Override
	@Transactional
	public Product get(String id) {
		return this.productDAO.get(id);
	}

	@Override
	@Transactional
	public Product getProductName(String name) {
		return this.productDAO.getProductName(name);
	}

	@Override
	@Transactional
	public void delete(String id) {
		this.productDAO.delete(id);
	}

	@Override
	@Transactional
	public void addProduct(Product product) {
		
		this.productDAO.addProduct(product);
	}
	
	@Override
	@Transactional
	public Map<String, String> getProduct(){
		
		List<Product> productList = this.productDAO.getAllProduct();
		
		Map<String, String> products = new LinkedHashMap<String, String>();
		
		for (Product product : productList) {
			products.put(product.getId(), product.getName());
		}
		
		return products;
		
	}

}
