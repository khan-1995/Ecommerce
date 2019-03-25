package com.niit.shoe.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoe.model.Cart;



@Transactional
@Repository("cartdao")
public class CartDaoImpl implements CartDao{

	@Autowired
	SessionFactory sf;
	public boolean addCart(Cart cart) {
		try {
			   sf.getCurrentSession().persist(cart);
			   return true;

			  } catch (Exception e) {
			   return false;
			  }
		
	}
	
	 public boolean deleteCart(Cart cart) {
		  try {
		   sf.getCurrentSession().remove(cart);
		   return true;
		  } catch (Exception e) {
		   return false;
		  }
		 }
		 public boolean updateCart(Cart cart) {
		  try {
		   sf.getCurrentSession().update(cart);
		   return true;
		  } catch (Exception e) {
		   return false;
		  }
		 }

		 public Cart getCart(int cartId) {
		  try {
		   return sf.getCurrentSession().get(Cart.class, cartId);
		  } catch (Exception e) {
		   System.out.println(e);
		   return null;
		  }
		  
		 }
}


