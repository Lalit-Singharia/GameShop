package com.niit.gameShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gameShop.dao.userDao;
import com.niit.gameShop.model.Cart;
import com.niit.gameShop.model.Role;
import com.niit.gameShop.model.User;
import com.niit.gameShop.model.userModel;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private userDao userDAO;
	@Autowired 
	private BasicUserService basicUserService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private CartService cartService;
	
	public void setUserDAO(userDao UserDAO)
	{
		this.userDAO = UserDAO;
	}
	
	@Override
	@Transactional
	public List<userModel> getAllUser() {
		return this.userDAO.getAllUser();
	}

	@Override
	@Transactional
	public userModel get(String id) {
		return this.get(id);
	}

	@Override
	@Transactional
	public userModel getUserName(String email_Id) {
		return this.userDAO.getUserName(email_Id);
	}

	@Override
	@Transactional
	public void delete(String id) {
		 this.userDAO.delete(id);
	}

	@Override
	@Transactional
	public void addUser(userModel user) {
		// First create the instance of the basic user
		User basicUser = new User();
		// set the basic user details to store inside the database
		basicUser.setId(user.getId());
		basicUser.setEmail_Id(user.getEmail_Id());
		basicUser.setPassword(user.getPassword());
		basicUser.setEnabled(true);

		// First create the role 
		Role role = new Role();
		role.setEmail_Id(user.getEmail_Id());
		role.setAuthority("ROLE_USER");
		
		//Cart
		Cart cart = new Cart();
		
		cart.setUserId(user.getId());
		
		this.cartService.addCart(cart);
		
		user.setCartId(cart.getId());
		
		this.basicUserService.addUser(basicUser);
		this.roleService.addUser(role);
		this.userDAO.addUser(user);
	}

}
