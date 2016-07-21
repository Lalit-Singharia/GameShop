package com.niit.gameShop.dao;

import java.util.List;
import com.niit.gameShop.model.Supplier;


public interface SupplierDao {
	
	public List<Supplier> getAllSupplier();

	public Supplier get(String id);

	public void delete(String id);
	
	public void addSupplier(Supplier supplier);

}
