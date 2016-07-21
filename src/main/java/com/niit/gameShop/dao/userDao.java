package com.niit.gameShop.dao;

import java.util.List;

import com.niit.gameShop.model.userModel;


public interface userDao {

	public List<userModel> getAllUser();

	public userModel get(String id);
	
	public userModel getUserName(String email_Id);

	public void delete(String id);
	
	public void addUser(userModel user);
}
