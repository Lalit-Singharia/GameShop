package com.niit.gameShop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.gameShop.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Category> getAllCategory() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Category");
		List<Category> category = query.list();
		return category;
	}

	@Override
	public Category get(String id) {
		Session session = sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, id);
		
		return category;
	}

	@Override
	public void delete(String id) {
		Category categoryDelete = new Category();
		categoryDelete.setId(id);
		sessionFactory.getCurrentSession().delete(categoryDelete);
	}

	@Override
	public void addCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}

}
