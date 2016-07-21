package com.niit.gameShop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.gameShop.model.userModel;

@Repository
public class userDaoImpl implements userDao {


	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	
	@Override
	public List<userModel> getAllUser() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from userModel");
		List<userModel> user = query.list();
		return user;
	}

	@Override
	public userModel get(String id) {
		Session session = sessionFactory.getCurrentSession();
		userModel user = (userModel) session.get(userModel.class, id);

		return user;
	}
	
	@Override
	public userModel getUserName(String email_Id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from userModel as u where u.email_Id =?");
		
		query.setParameter(0, email_Id);
		
		return (userModel)query.uniqueResult();
	}

	@Override
	public void delete(String id) {
		
		userModel userDelete = new userModel();
		userDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userDelete);
	}

	@Override
	public void addUser(userModel user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

}
