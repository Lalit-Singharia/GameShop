package com.niit.gameShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.gameShop.model.CartItem;
import com.niit.gameShop.service.CartItemService;
import com.niit.gameShop.service.CategoryService;
import com.niit.gameShop.service.ProductService;
import com.niit.gameShop.service.SupplierService;

@Controller
public class DeleteAndEdit {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@RequestMapping(value = "/Product/delete/{id}" )
	public String deleteproduct(@PathVariable("id") String id, ModelMap model ) 
	{	
		this.productService.delete(id);
		model.addAttribute("message", "Successfully Added");

		return "redirect:/ViewProduct";
	}
	
	@RequestMapping("/Product/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("Product", this.productService.get(id));
		
		model.addAttribute("categories", this.categoryService.getCategories());
		
		model.addAttribute("suppliers", this.supplierService.getSuppliers());
	
		return "admin/Product";
	}
	
	@RequestMapping(value = "/Category/delete/{id}" )
	public String deleteCategory(@PathVariable("id") String id, ModelMap model ) 
	{	
		this.categoryService.delete(id);
		model.addAttribute("message", "Successfully Added");

		return "redirect:/ViewCategory";
	}
	
	@RequestMapping("/Category/edit/{id}")
	public String editCategoey(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("Category", this.categoryService.get(id));
	
		return "admin/Category";
	}
	
	@RequestMapping(value = "/Supplier/delete/{id}" )
	public String deleteSupplier(@PathVariable("id") String id, ModelMap model ) 
	{	
		this.supplierService.delete(id);
		model.addAttribute("message", "Successfully Added");

		return "redirect:/ViewSupplier";
	}
	
	@RequestMapping("/Supplier/edit/{id}")
	public String editSupplier(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("Supplier", this.supplierService.get(id));
	
		return "admin/Supplier";
	}
	
	
	@RequestMapping(value ={ "/CartItem/delete/{id}"} )
	public String deleteCart(@PathVariable("id") int id, Model model ) 
	{	
		this.cartItemService.deleteCartItem(id);
		model.addAttribute("message", "Successfully Added");

		return "redirect:/Cart";
	}
	
}
