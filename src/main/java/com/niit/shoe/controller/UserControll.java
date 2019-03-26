package com.niit.shoe.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoe.dao.CategoryDao;
import com.niit.shoe.dao.ProductShoeDao;
import com.niit.shoe.dao.UserDao;
import com.niit.shoe.model.Cart;
import com.niit.shoe.model.Category;
import com.niit.shoe.model.Product;
import com.niit.shoe.model.UserValidation;

@Controller
public class UserControll {
	
	@Autowired
	CategoryDao categorydao;
	
	@Autowired
	ProductShoeDao productDao;
	
	@Autowired
	UserDao cuserdaoi;
	
	@RequestMapping("/user")
	public ModelAndView product(Model m,Principal p){
		 if (p != null){
			
			 UserValidation createuser = cuserdaoi.getUserDetails(p.getName());
			   
			  Cart cart = createuser.getCart(); 
			  m.addAttribute("cart",cart);
			  
			  m.addAttribute(createuser);
			   
	        }
		
		
		Product product = new Product();
		m.addAttribute(product);
		List<Product> listproducts = productDao.retrievedAllData(); 
		m.addAttribute("prodlist",listproducts);
		
		List<Category> listcategories = categorydao.retrievedAllData();
		m.addAttribute("catlist", listcategories);
		
		return  new ModelAndView("Userpage");
	}
	
	@RequestMapping(value = "/productinfo/{productid}", method = RequestMethod.GET)
	 public ModelAndView prodDisplay(@PathVariable("productid") int productid, Model m, Principal principal) {
	  if (principal != null) {
	   UserValidation createuser = cuserdaoi.getUserDetails(principal.getName());
	   Cart cart = createuser.getCart();
	   m.addAttribute("cart",cart);
	   m.addAttribute(createuser);
	  }
	  List<Category> listcategories = categorydao.retrievedAllData();															
	  m.addAttribute("catlist", listcategories);
	  Product product = productDao.getProductid(productid);
	  m.addAttribute(product);
	  
	  return new ModelAndView("productinfo");
	 }
	
	
	

}
