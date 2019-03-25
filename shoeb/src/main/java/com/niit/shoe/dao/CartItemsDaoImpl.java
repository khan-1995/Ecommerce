package com.niit.shoe.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.shoe.model.Cart;
import com.niit.shoe.model.CartItems;
import com.niit.shoe.model.Product;

@Transactional
@Repository("cartitems")
public class CartItemsDaoImpl implements CartItemsDao{
	
	

		@Autowired
		SessionFactory sf;
		
		public boolean addCart(CartItems cartItems) {
			try {
				 sf.getCurrentSession().save(cartItems);
				   return true;
			}
			
			catch(Exception e) {
				System.out.print(" "+e);
				return false;	
			}
			
		}
		
		public CartItems getProduct(int productid, int cartId) {
			try {
				return sf.getCurrentSession()
						.createQuery("from CartItems where cart_cartId = :cartId and product_productId = :productid",
					       CartItems.class)
					     .setParameter("cartId", cartId).setParameter("productId", productid).getSingleResult();
			}catch (Exception e) {
				System.out.println(""+e);
				return null;
			}	
		}

		public boolean deletCartItems(CartItems cartItems) {
			try {
				   sf.getCurrentSession().remove(cartItems);
				   return true;
				  } catch (Exception e) {
				   return false;
				  }
		}

		public boolean updateCartItems(CartItems cartItems) {
			 try {
				   sf.getCurrentSession().update(cartItems);
				   return true;
				  } catch (Exception e) {
				   return false;
				  }
		}

		public CartItems getCartItems(int cartItemId) {
			 try {
				   return sf.getCurrentSession().get(CartItems.class, cartItemId);
				  } catch (Exception e) {
				   System.out.println(e);
				   return null;
				  }
		}

		public ArrayList<CartItems> retreiveAllCartItems() {
			try {
				   return (ArrayList<CartItems>) sf.getCurrentSession()
				     .createQuery("from CartItems", CartItems.class).getResultList();
				  } catch (HibernateException e) {
				   e.printStackTrace();
				   return null;
				  }
		}
		

}
