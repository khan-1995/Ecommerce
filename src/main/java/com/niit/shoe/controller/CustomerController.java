package com.niit.shoe.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.niit.shoe.dao.CartDao;
import com.niit.shoe.dao.CartItemsDao;
import com.niit.shoe.dao.ProductShoeDao;
import com.niit.shoe.dao.UserDao;
import com.niit.shoe.model.Cart;
import com.niit.shoe.model.CartItems;
import com.niit.shoe.model.Product;
import com.niit.shoe.model.UserValidation;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	 @Autowired
	 ProductShoeDao productDao;
	 
	 @Autowired
	 UserDao createuserDao;
	 
	 @Autowired
	 CartDao cartDao;
	 
	 @Autowired
	 CartItemsDao cartItemDao;
	 
	 
	 @RequestMapping("/addToCart/{productid}")
	 public String addToCart(@PathVariable("productid") int productid, Model m, @RequestParam(value ="quantity") int quantity, Principal principal)
	 {
	  System.out.println(principal);
	  Product product = productDao.getProductid(productid);
	  UserValidation createuser = createuserDao.getUserDetails(principal.getName());
	  Cart cart = createuser.getCart();
	  
	//  if(cart == null)
	//  {
	//   cart=new Cart();
	//  }
		  
	  CartItems cartItems =  cartItemDao.getProduct(productid, cart.getCartId());
	  
	  if(cartItems==null)
	  {
	   cartItems = new CartItems();
	   cartItems.setProduct(product);
	   cartItems.setCartItemQty(quantity); 
	   cartItems.setCart(cart);
	   cartItems.setCartItemPrice(cartItems.getCartItemQty() * product.getProductprice());/*setCartItemPrice*/
	   ArrayList<CartItems> itemsList=new ArrayList<CartItems>();
	   itemsList.add(cartItems);
	   cart.setQty(cart.getQty()+cartItems.getCartItemQty());
	   cart.setTotalAmount(cart.getTotalAmount()+cartItems.getCartItemPrice());
	   cart.setLstcartitem(itemsList);
	   m.addAttribute("cartItems",itemsList);
	   cartItemDao.addCart(cartItems);
	  }else{
	   cartItems.setProduct(product);
	   cartItems.setCartItemPrice(cartItems.getCartItemPrice()+(quantity * product.getProductprice()));
	   cartItems.setCartItemQty(cartItems.getCartItemQty()+quantity);
	   ArrayList<CartItems> itemsList=new ArrayList<CartItems>();
	   itemsList.add(cartItems);
	   cart.setQty(cart.getQty()+cartItems.getCartItemQty());
	   cart.setTotalAmount(cart.getTotalAmount()+(quantity * product.getProductprice()));
	   cart.setLstcartitem(itemsList);
	   m.addAttribute("cartItems",itemsList);
	   cartItemDao.updateCartItems(cartItems);
	  }
	  
	  cartDao.updateCart(cart);
	  m.addAttribute(product);
	  m.addAttribute(cart);
	  return "redirect:/customer/mycart";
	 }
	 
	 
	 @RequestMapping("/mycart")
	 public String mycart(Model m, Principal principal)
	 {
	  System.out.println(principal);
	  UserValidation createuser=createuserDao.getUserDetails(principal.getName());
	  Cart cart = createuser.getCart();
	  m.addAttribute(cart);
	  List<CartItems> cartItems = cart.getLstcartitem();
	  m.addAttribute("cartItems",cartItems);
	  return "mycart";
	 }
	 
	 
	 @RequestMapping(value="/editCartItems/{cartItemId}")
	 public String editcartItem(@PathVariable(value="cartItemId")int id, Model m, @RequestParam(value ="quantity") int quantity, Principal p)
	 {

	  CartItems cartItem = cartItemDao.getCartItems(id);
	  UserValidation createUser = createuserDao.getUserDetails(p.getName());
	  Cart cart = createUser.getCart();
	  cart.setQty(cart.getQty()-cartItem.getCartItemQty());
	  cart.setTotalAmount(cart.getTotalAmount()-cartItem.getCartItemPrice());
	  Product product = cartItem.getProduct();
	  cartItem.setCartItemQty(quantity);
	  cartItem.setCartItemPrice(quantity*product.getProductprice());
	  cart.setCartId(cartItem.getCart().getCartId());
	  cart.setQty(cart.getQty()+cartItem.getCartItemQty());
	  cart.setTotalAmount(cart.getTotalAmount()+cartItem.getCartItemPrice());
	  cartItemDao.updateCartItems(cartItem);
	  createUser.setCart(cart);
	  cartDao.updateCart(cart);
	  return "redirect:/customer/mycart";
	  
	 }
	 
	 
	 @RequestMapping(value="deleteCartItems/{cartItemId}/cartItem")
	 public String deleteCartItem(@PathVariable("cartItemId")int id,Model m, Principal p)
	 {
	  CartItems cartItem = cartItemDao.getCartItems(id);
	  UserValidation createuser = createuserDao.getUserDetails(p.getName());
	  Cart cart = createuser.getCart();
	  cart.setCartId(cartItem.getCart().getCartId());
	     cart.setQty(cart.getQty() - cartItem.getCartItemQty());
	     cart.setTotalAmount(cart.getTotalAmount()+cartItem.getCartItemPrice());
	      createuser.setCart(cart);
	   cartDao.updateCart(cart);
	  cartItemDao.deletCartItems(cartItem);
	  
	  return "redirect:/customer/mycart";
	 }
	 
	
	
	
}
