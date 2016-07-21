package com.niit.gameShop.service;

import java.util.List;
import java.util.Map;

import com.niit.gameShop.model.Supplier;

public interface SupplierService {
	
	public List<Supplier> getAllSupplier();

	public Supplier get(String id);

	public void delete(String id);
	
	public void addSupplier(Supplier supplier);
	
	public Map<String, String> getSuppliers();

}
