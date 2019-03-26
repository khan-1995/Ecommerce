package com.niit.shoe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class CartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;
	
	
	@NotNull(message = "please fill this field")
	/* @NotEmpty(message = "Please fill this field") */
	private int cartItemQty;
	
	@NotNull(message = "please fill this field")
	//@NotEmpty(message = "Please fill this field")
	private int cartItemPrice;
	
	@NotNull(message = "please fill this field")
	//@NotEmpty(message = "Please fill this field")
	@OneToOne(fetch=FetchType.EAGER)
	private Product product;
	
	@NotNull(message = "please fill this field")
	//@NotEmpty(message = "Please fill this field")
	@ManyToOne
	private Cart cart;

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getCartItemQty() {
		return cartItemQty;
	}

	public void setCartItemQty(int cartItemQty) {
		this.cartItemQty = cartItemQty;
	}

	public int getCartItemPrice() {
		return cartItemPrice;
	}

	public void setCartItemPrice(float f) {
		this.cartItemPrice = (int) f;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	
	
}
