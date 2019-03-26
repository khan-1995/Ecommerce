package com.niit.shoe.controller;

import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.niit.shoe.dao.CartDao;
import com.niit.shoe.dao.CategoryDao;
import com.niit.shoe.dao.ProductShoeDao;
import com.niit.shoe.dao.UserDao;
import com.niit.shoe.model.Cart;
import com.niit.shoe.model.Category;
import com.niit.shoe.model.Product;
import com.niit.shoe.model.UserValidation;

@Controller
public class ShoeControll {

	@Autowired
	UserDao userdao;
	
	@Autowired
	 CartDao cartDao;
	
	@Autowired
	CategoryDao categorydao;
	
	@Autowired
	ProductShoeDao productdao;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	 public ModelAndView homePage(Model m,Principal p) {
		System.out.println("th evalue is"+p);
		 if(p !=null) {
			  
		   System.out.println("you are "+p.getName());
		   UserValidation usrv = userdao.getUserDetails(p.getName());
		   
			if (!usrv.getRole().equals("ROLE_ADMIN")){
				
				  Cart cart = usrv.getCart();  
				    m.addAttribute("cart",cart);
			        m.addAttribute("user", usrv);
			    
			        return new ModelAndView("index");
			   }
			
			else 
			{
			    System.out.println("not logged in");
			 
			    return new ModelAndView("index");
			    
			 }	  
			
		 }
		 
		  return new ModelAndView("index");
		 
		
	}

	@RequestMapping("/login")
	public String loginpage(Model m)
	{
		
		  List<Product> listProducts = productdao.retrievedAllData();
		  m.addAttribute("prodlist", listProducts);
		  
		  List<Category> listcategories = categorydao.retrievedAllData();
		  m.addAttribute("catlist", listcategories);
		  
		  return "login";
		 
	}

	@RequestMapping("/reg")
	public ModelAndView reg(Model m) {
		UserValidation usrv = new UserValidation();
		m.addAttribute("user", usrv);
		return new ModelAndView("signup");
	}

	@RequestMapping("/signup")
	public String signupage(@Valid @ModelAttribute("user") UserValidation usrv , BindingResult result , Model m)throws Exception
	{
		if(result.hasErrors())
		{
			m.addAttribute("user", usrv);
			return "signup";
		}
		else {
			
			Cart cart = new Cart();
		     usrv.setCart(cart);
		     cart.setUser(usrv);
			
				userdao.addCreate(usrv);
				cartDao.addCart(cart);
			
				List<Category> listcat = categorydao.retrievedAllData();
				m.addAttribute("catlist", listcat);
				    return "redirect:/";
			
		}
			
		
	}

}