package com.niit.gameShop.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.gameShop.model.Cart;
import com.niit.gameShop.model.CartItem;
import com.niit.gameShop.model.Category;
import com.niit.gameShop.model.Product;
import com.niit.gameShop.model.Supplier;
import com.niit.gameShop.model.userModel;
import com.niit.gameShop.service.CartItemService;
import com.niit.gameShop.service.CartService;
import com.niit.gameShop.service.CategoryService;
import com.niit.gameShop.service.ProductService;
import com.niit.gameShop.service.SupplierService;
import com.niit.gameShop.service.UserService;

@Controller
public class PageController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping(value = {"/", "/index"})
	public String home()
	{
		/*
		 * Code to add a dummy user
		 * 
		 * */
/*		userModel user = new userModel();
		user.setName("Lalit Singharia");
		user.setPassword("admin");
		user.setEmail_Id("lalit.singharia@gmail.com");
		user.setContactNumber("98190000000");
		
		this.userService.addUser(user);
		
		Dummmy Code for product
		
		Product product = new Product();
		product.setId("1");
		product.setName("Hitman");
		product.setDescription("Hitman game for PS4");
		
		product.setCategoryId("1");
		
		this.productService.addProduct(product);
		*/
		
		return "guest/index" ;
	}
	
	
	@RequestMapping(value = {"/SignUP"})
	public String Register(Model model)
	{
		model.addAttribute("userModel", new userModel());
		
		return "guest/SignUP" ;
	}
	
	
	
	
	@RequestMapping(value = {"/Product"})
	public String Product(Model model)
	{
		model.addAttribute("Product", new Product());
		
		model.addAttribute("categories", this.categoryService.getCategories());
		
		model.addAttribute("suppliers", this.supplierService.getSuppliers());
		
		return "admin/Product" ;
	}
	
	@RequestMapping(value={"/Supplier"})
	public String supplier(Model model)
	{
		model.addAttribute("Supplier", new Supplier());
		
		return "admin/Supplier";
	}
	
	
	
	@RequestMapping(value = {"/ViewProduct"})
	public String viewProduct(Model model){
		
		model.addAttribute("productList", this.productService.getAllProduct());
		
		return "admin/ViewProduct";
	}
	
	@RequestMapping(value={"/Category"})
	public String category(Model model){
		model.addAttribute("Category", new Category());
		
		return "admin/Category";
	}
	
	@RequestMapping(value={"/login"})
	public String login(Model model){		
		//model.addAttribute("User", new User());
		
		return "guest/Login";
	}

	
	@RequestMapping(value={"/ViewCategory"})
	public String ViewCategory(Model model){
		
		model.addAttribute("categoryList", this.categoryService.getAllCategory());
		
		return "admin/ViewCategory";
	}
	
	@RequestMapping(value={"/ViewSupplier"})
	public String ViewSupplier(Model model){
		
		model.addAttribute("supplierList", this.supplierService.getAllSupplier());
		
		return "admin/ViewSupplier";
	}

	@RequestMapping(value={"/logout"}, method = RequestMethod.GET)
	 public String logout(HttpServletRequest request, HttpServletResponse response) {
	 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		
	  return "redirect:/login";
	 
	 }
	
	@RequestMapping(value ={"/Cart"})
	public String viewCart(Model model){
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		userModel user = this.userService.getUserName(username);
		
		Cart cart = this.cartService.getCart(user);
		
		model.addAttribute("cartList", this.cartItemService.getItemsByEmailId(username));
		
		model.addAttribute("grandTotal", cart.getGrandTotal());
		
		
		
				
		return "user/Cart";
	}
	
	@RequestMapping(value ={"/aboutUS"})
	public String aboutUS(Model model){
		
		
		return "guest/aboutUS";
		
	}
	

}
