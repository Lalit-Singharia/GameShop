package com.niit.gameShop.dao;

import com.niit.gameShop.model.Role;

public interface RoleDao {
	
	public Role get(String id);
	
	public Role getUserName(String email_Id);
	
	public void addUser(Role role);


}
