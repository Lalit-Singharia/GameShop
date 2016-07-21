package com.niit.gameShop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.gameShop.model.CartItem;

@Repository
public class CartItemDaoImpl implements CartItemDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory; 
	}

	@Override
	public List<CartItem> getAllItem() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartItem");
		
		List<CartItem> cartItem = query.list();
		
		return cartItem;
	}

	@Override
	public void addCartItem(CartItem cartItem) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
	}

	@Override
	public void deleteCartItem(int id) {
		
		CartItem cartItem = new CartItem();
		
		cartItem.setId(id);
		
		this.sessionFactory.getCurrentSession().delete(cartItem);
	}

	@Override
	public List<CartItem> getItemsByEmailId(String userId) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from CartItem as c where c.userId=?");
		
		query.setParameter(0, userId);
		
		return (List<CartItem>) query.list();
		
	}

}
