package com.niit.shoe.testcase;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoe.dao.CartDao;
import com.niit.shoe.dao.ProductShoeDao;
import com.niit.shoe.dao.UserDao;
import com.niit.shoe.db_configuration.HibernateConfiguration;
import com.niit.shoe.model.Cart;
import com.niit.shoe.model.CartItems;
import com.niit.shoe.model.Product;


public class CartTest {

	UserDao usd;
	ProductShoeDao psd;
	Cart cart;
	Product ps;
	CartDao cartd;
	CartItems cartitem;
	AnnotationConfigApplicationContext context;

	List<CartItems> crtitm;

	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
		psd = (ProductShoeDao) context.getBean("productdao");
		usd = (UserDao) context.getBean("users");
		cartd = (CartDao) context.getBean("cartdao");
		cart = new Cart();
		cartitem = new CartItems();

		ps = psd.getProductid(1);
		cartitem.setProduct(ps);

		cart.setUser(usd.getCuserid(1));
		cartitem.setCart(cart);
		cartitem.setProduct(ps);

		
		  cartitem.setCartItemPrice(ps.getProductprice());
		  cartitem.setCartItemQty(1);
		 crtitm = new ArrayList<CartItems>();

		crtitm.add(cartitem);

		
		  cart.setQty(cartitem.getCartItemQty());
		  cart.setTotalAmount(cartitem.getCartItemPrice());
		 cart.setLstcartitem(crtitm);

	}

	@Test
	public void test() {
		assertEquals(true, cartd.addCart(cart));

	}

}