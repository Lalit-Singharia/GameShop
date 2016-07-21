package com.niit.gameShop.service;

import java.util.List;

import com.niit.gameShop.model.CartItem;
import com.niit.gameShop.model.Product;
import com.niit.gameShop.model.userModel;

public interface CartItemService {
	
	public List<CartItem> getAllItem();
	
	public List<CartItem> getItemsByEmailId(String userId);
	
	public void addCartItem(Product product, userModel user);
	
	public void deleteCartItem(int id);

}
