package com.niit.shoe.dao;

import com.niit.shoe.model.Cart;

public interface CartDao {

	
	public boolean addCart(Cart cart);
	 public boolean deleteCart(Cart cart);
	 public boolean updateCart(Cart cart);
	 public Cart getCart(int cartId);
}