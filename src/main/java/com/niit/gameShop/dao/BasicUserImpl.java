package com.niit.gameShop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.gameShop.model.User;

@Repository
public class BasicUserImpl implements BasicUser {


	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}

	
	@Override
	public User enableUser(boolean enable) {
		Session session = sessionFactory.getCurrentSession();		
		User basicUser = (User) session.get(User.class, enable);
		
		return basicUser;
	}

	@Override
	public User get(String id) {
		Session session = sessionFactory.getCurrentSession();
		User basicUser = (User) session.get(User.class, id);
		return basicUser;
	}

	@Override
	public User getUserName(String email_Id) {
		Session session = sessionFactory.getCurrentSession();
		User basicUser = (User) session.get(User.class, email_Id);

		return basicUser;
	}

	@Override
	public void addUser(User basicUser) {
		sessionFactory.getCurrentSession().saveOrUpdate(basicUser);

	}

}
