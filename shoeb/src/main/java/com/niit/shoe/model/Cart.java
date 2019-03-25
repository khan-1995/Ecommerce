package com.niit.shoe.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Cart {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
 
 
	@NotNull(message = "please fill this field")
	////@NotEmpty(message = "Please fill this field")
    private float totalAmount;

 
	@NotNull(message = "please fill this field")
	////@NotEmpty(message = "Please fill this field")
    private int Qty;
	
	@OneToMany(mappedBy="cart",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<CartItems> lstcartitem;
	
	
 
 public List<CartItems> getLstcartitem() {
		return lstcartitem;
	}
	public void setLstcartitem(List<CartItems> lstcartitem) {
		this.lstcartitem = lstcartitem;
	}
 
 @OneToOne
 private UserValidation user;
 
 public UserValidation getUser() {
	return user;
}
public void setUser(UserValidation user) {
	this.user = user;
}
public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public float getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(float totalAmount) {
	this.totalAmount = totalAmount;
}
public int getQty() {
	return Qty;
}
public void setQty(int qty) {
	Qty = qty;
}

	
}