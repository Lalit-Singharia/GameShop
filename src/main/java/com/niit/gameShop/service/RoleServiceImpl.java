package com.niit.gameShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gameShop.dao.RoleDao;
import com.niit.gameShop.dao.userDao;
import com.niit.gameShop.model.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDAO;
	
	public void setRoleDAO(RoleDao roleDAO)
	{
		this.roleDAO = roleDAO;
	}
	
	@Override
	@Transactional
	public Role get(String id) {
		return this.roleDAO.get(id);
	}

	@Override
	@Transactional
	public Role getUserName(String email_Id) {
		return this.roleDAO.getUserName(email_Id);
	}

	@Override
	@Transactional
	public void addUser(Role role) {
		this.roleDAO.addUser(role);
	}

}
