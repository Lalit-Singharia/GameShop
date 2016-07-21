package com.niit.gameShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gameShop.dao.CartItemDao;
import com.niit.gameShop.model.Cart;
import com.niit.gameShop.model.CartItem;
import com.niit.gameShop.model.Product;
import com.niit.gameShop.model.userModel;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemDao cartItemDAO;
	
	public void setCartItemDAO(CartItemDao cartItemDAO){
		this.cartItemDAO = cartItemDAO;
	}

	@Override
	@Transactional
	public List<CartItem> getAllItem() {
		return this.cartItemDAO.getAllItem();
	}
	
	public void cart(Product product, userModel user){

		CartItem cartItem = new CartItem();
		
		cartItem.setUserId(user.getEmail_Id());
				
		cartItem.setProductId(product.getId());
		
		cartItem.setQuantity(1);
		
		cartItem.setTotalPrice(product.getPrice());
		
		this.cartItemDAO.addCartItem(cartItem);
	}

	@Override
	@Transactional
	public void addCartItem(Product product, userModel user) {
		
		if (this.cartItemDAO.getAllItem() == null){ 
			cart(product, user);
		}
		
		List<CartItem> cartItemList = this.cartItemDAO.getItemsByEmailId(user.getEmail_Id());
		
		for (CartItem cartItem : cartItemList) {
			if(product.getId().equals(cartItem.getProductId())){
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(product.getPrice()*cartItem.getQuantity());
				return;
			}
		}
		
		cart(product, user);
	}

	@Override
	@Transactional
	public void deleteCartItem(int id) {
		
		this.cartItemDAO.deleteCartItem(id);
	}

	@Override
	@Transactional
	public List<CartItem> getItemsByEmailId(String userId){
		return this.cartItemDAO.getItemsByEmailId(userId);
	}
	

}
