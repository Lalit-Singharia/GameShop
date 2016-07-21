package com.niit.gameShop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.gameShop.model.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		
	@Override
	public List<Supplier> getAllSupplier() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> supplier = query.list();
		return supplier;
	}

	@Override
	public Supplier get(String id) {
		Session session = sessionFactory.getCurrentSession();
		Supplier supplier = session.get(Supplier.class, id);
		
		return supplier;
	}

	@Override
	public void delete(String id) {
		Supplier supplier = new Supplier();
		supplier.setId(id);
		sessionFactory.getCurrentSession().delete(supplier);
	}

	@Override
	public void addSupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}

}
