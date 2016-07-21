package com.niit.gameShop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.gameShop.model.Cart;
import com.niit.gameShop.model.CartItem;
import com.niit.gameShop.model.Category;
import com.niit.gameShop.model.Product;
import com.niit.gameShop.model.Supplier;
import com.niit.gameShop.model.userModel;
import com.niit.gameShop.service.CartItemService;
import com.niit.gameShop.service.CategoryService;
import com.niit.gameShop.service.ProductService;
import com.niit.gameShop.service.SupplierService;
import com.niit.gameShop.service.UserService;

@Controller
public class OpertionController {
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CartItemService cartItemService;

	@RequestMapping(value = {"/Supplier/add"}, method=RequestMethod.POST)
	public String addSupplier(@Valid @ModelAttribute("Supplier")Supplier supplier, BindingResult results, Model model)
	{
		if(results.hasErrors())
		{
			return "admin/Supplier";
		}
		
		this.supplierService.addSupplier(supplier);
		
		return "redirect:/ViewSupplier" ;
	}
	
	
	@RequestMapping(value = {"/Product/add"}, method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("Product")Product product, BindingResult results, Model model)
	{
		
		System.out.println(product);
		
		if(results.hasErrors()) {
			
			return "admin/Product";
			
		}
		this.productService.addProduct(product);
		
		return "redirect:/ViewProduct" ;
	}
	
	
	@RequestMapping(value = {"/register"}, method=RequestMethod.POST)
	public String newRegister(@Valid @ModelAttribute("userModel")userModel user, BindingResult results, Model model)
	{
		if(results.hasErrors())
		{
			return "guest/SignUP";
		}
		
		this.userService.addUser(user);
		
		return "redirect:/login" ;
	}
	
	@RequestMapping(value={"/Category/add"}, method = RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("Category") Category category, BindingResult results, Model model)
	{
		if(results.hasErrors()){
			return "admin/Category";
		}
		
		this.categoryService.addCategory(category);
		
		return "redirect:/ViewCategory";
		
	}
	
	@RequestMapping(value = {"/Product/AddToCart/{id}"})
	public String ViewCart(@PathVariable("id")String id ,Model model){
		
		String email_Id = SecurityContextHolder.getContext().getAuthentication().getName();
		
		userModel user = this.userService.getUserName(email_Id);
		
		this.cartItemService.addCartItem(this.productService.get(id), user);
				
		model.addAttribute("message", "Successfully Added");
		
		return "redirect:/ViewProduct";
	}

}
