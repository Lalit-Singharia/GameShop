package com.niit.gameShop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.gameShop.model.Cart;
import com.niit.gameShop.model.CartItem;
import com.niit.gameShop.model.userModel;
import com.niit.gameShop.service.CartItemService;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CartItemService cartItemService;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCart(Cart cart) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	@Override
	public void deleteCart(Cart cart) {
		this.sessionFactory.getCurrentSession().delete(cart);
	}

	@Override
	public Cart getCart(userModel user) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Cart as c where c.userId = ?");
		
		query.setParameter(0, user.getId());
		
		Cart cart = (Cart) query.uniqueResult();
		
		List<CartItem> cartItemList = this.cartItemService.getItemsByEmailId(user.getEmail_Id());
		
		double i = 0;
		
		for (CartItem cartItem : cartItemList){
			i = i + cartItem.getTotalPrice();
		}
		
		cart.setUserId(user.getId());
		
		
		cart.setGrandTotal(i);
		
		addCart(cart);
		
		return cart;
	}
	
	

}
