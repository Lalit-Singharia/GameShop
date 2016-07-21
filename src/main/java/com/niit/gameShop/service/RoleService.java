package com.niit.gameShop.service;

import com.niit.gameShop.model.Role;

public interface RoleService {
	
	public Role get(String id);
	
	public Role getUserName(String email_Id);
	
	public void addUser(Role role);


}
