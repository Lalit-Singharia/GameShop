package com.niit.gameShop.service;

import com.niit.gameShop.model.User;

public interface BasicUserService {
	
public User get(String id);
	
	public User getUserName(String email_Id);
	
	public void addUser(User basicUser);
	
}
