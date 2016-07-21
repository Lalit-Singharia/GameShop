package com.niit.gameShop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.gameShop.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	
	@Override
	public Role get(String id) {
		
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, id);

		return role;
	}

	@Override
	public Role getUserName(String email_Id) {
		
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, email_Id);

		return role;
	}

	@Override
	public void addUser(Role role) {
		sessionFactory.getCurrentSession().saveOrUpdate(role);
	}

}
