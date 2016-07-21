package com.niit.gameShop.service;

import com.niit.gameShop.model.Cart;
import com.niit.gameShop.model.userModel;

public interface CartService {
	
	public Cart getCart(userModel user);
	
	public void addCart(Cart cart );
	
	public void deleteCart(Cart cart);

}
