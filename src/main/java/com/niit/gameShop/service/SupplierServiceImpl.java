package com.niit.gameShop.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gameShop.dao.SupplierDao;
import com.niit.gameShop.model.Supplier;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao supplierDAO;
	
	public void setSupplierDAO(SupplierDao supplierDAO){
		this.supplierDAO = supplierDAO;
	}
	
	@Override
	@Transactional
	public List<Supplier> getAllSupplier() {
		return this.supplierDAO.getAllSupplier();
	}

	@Override
	@Transactional
	public Supplier get(String id) {
		return this.supplierDAO.get(id);
	}

	@Override
	@Transactional
	public void delete(String id) {
		this.supplierDAO.delete(id);
	}

	@Override
	@Transactional
	public void addSupplier(Supplier supplier) {
		this.supplierDAO.addSupplier(supplier);
	}

	@Override
	@Transactional
	public Map<String, String> getSuppliers() {
		List<Supplier> supplierList = this.supplierDAO.getAllSupplier();
		Map<String, String> suppliers = new LinkedHashMap<String, String>();
		
		for (Supplier supplier : supplierList) {
			suppliers.put(supplier.getId(), supplier.getName());
		}
		
		return suppliers;
	}

	
}
