package com.niit.gameShop.dao;

import java.util.List;

import com.niit.gameShop.model.CartItem;

public interface CartItemDao {
	
	public List<CartItem> getAllItem();
	
	public List<CartItem> getItemsByEmailId(String userId);
	
	public void addCartItem(CartItem cartItem);
	
	public void deleteCartItem(int id);
}
