package com.niit.gameShop.dao;

import com.niit.gameShop.model.User;

public interface BasicUser {
	
	public User get(String id);
	
	public User getUserName(String email_Id);
	
	public void addUser(User basicUser);
	
	public User enableUser(boolean enable);

}
