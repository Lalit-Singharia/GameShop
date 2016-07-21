package com.niit.gameShop.dao;

import com.niit.gameShop.model.Cart;
import com.niit.gameShop.model.userModel;

public interface CartDao {
	
	public Cart getCart(userModel user);
	
	public void addCart(Cart cart);
	
	public void deleteCart(Cart cart);

}
