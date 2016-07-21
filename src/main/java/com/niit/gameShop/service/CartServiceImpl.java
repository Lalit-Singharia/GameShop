package com.niit.gameShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gameShop.dao.CartDao;
import com.niit.gameShop.model.Cart;
import com.niit.gameShop.model.CartItem;
import com.niit.gameShop.model.userModel;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDAO;
	
	@Autowired
	private CartItemService cartItemService;
	
	public void setCartDAO(CartDao cartDAO){
		this.cartDAO = cartDAO;
	}

	@Override
	@Transactional
	public void addCart(Cart cart) {
		
		this.cartDAO.addCart(cart);
	}

	@Override
	@Transactional
	public void deleteCart(Cart cart) {
		this.cartDAO.deleteCart(cart);
	}

	@Override
	@Transactional
	public Cart getCart(userModel user) {
		return this.cartDAO.getCart(user);
	}
	
	
		
}
