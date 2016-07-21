package com.niit.gameShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gameShop.dao.BasicUser;
import com.niit.gameShop.model.Cart;
import com.niit.gameShop.model.User;

@Service
public class BasicUserServiceImpl implements BasicUserService {
	
	@Autowired
	private BasicUser basicUserDAO;
	
	public void setBasicUserDAO(BasicUser basicUserDao)
	{
		this.basicUserDAO = basicUserDao;
	}

	@Override
	@Transactional
	public User get(String id) {
		return this.basicUserDAO.get(id);
	}

	@Override
	@Transactional
	public User getUserName(String email_Id) {
		return this.basicUserDAO.getUserName(email_Id);
	}

	@Override
	@Transactional
	public void addUser(User basicUser) {
		
	
		this.basicUserDAO.addUser(basicUser);
	}


}
