package com.niit.shoe.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.niit.shoe.model.Cart;
import com.niit.shoe.model.CartItems;

@Component
public interface CartItemsDao
{
	public boolean addCart(CartItems cartItems);
	public CartItems getProduct(int productId, int cartId);
	public boolean deletCartItems(CartItems cartItems);
	public boolean updateCartItems(CartItems cartItems);
	public CartItems getCartItems(int cartItemId);
	public ArrayList<CartItems> retreiveAllCartItems();
	 
	
}
