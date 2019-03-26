package com.niit.shoe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
public class UserValidation {

	private static final String DEFAULT_ROLE = "ROLE_USER";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cuserid;
	
	@NotNull(message = "please fill this field")
	@NotEmpty(message = "Please fill this field")
	//@Pattern(regexp = "[a-zA-Z]{4,12}", message = "Only Alphabets in the range 4-12 are accepted")
	private String name;
	
	/*
	 * @NotNull(message = "please fill this field")
	 * 
	 * @NotEmpty(message = "Please fill this field")
	 */
	@OneToOne(mappedBy="user")
	private Cart cart;
	
	@NotNull(message = "Please fill this field")
	//@Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@"
	//+ "[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$", message = "you can use @symbol , hiphen- and digits")
	private String email_id;
	
	@NotNull(message = "Please fill this field")
	private String address;
	
	@NotNull(message = "Please fill this field")
	private String primary_mobile;
	
	@NotNull(message = "Please fill this field")
	private String secondary_mobile;
	
	@NotNull(message = "Please fill this field")
	//@Pattern(regexp = "((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*\\W).{8,12})", message = "One UpperCase, One lowercase, one number and one special character are must in 8-12 character range")
	private String password;
	
	private boolean is_Active;
	private String role = DEFAULT_ROLE;
	
	public boolean isIs_Active() {
		return is_Active;
	}
	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static String getDefaultRole() {
		return DEFAULT_ROLE;
	}
	
	public String getName() {
		return name;
	}
	public int getCuserid() {
		return cuserid;
	}
	public void setCuserid(int cuserid) {
		this.cuserid = cuserid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrimary_mobile() {
		return primary_mobile;
	}
	public void setPrimary_mobile(String primary_mobile) {
		this.primary_mobile = primary_mobile;
	}
	public String getSecondary_mobile() {
		return secondary_mobile;
	}
	public void setSecondary_mobile(String secondary_mobile) {
		this.secondary_mobile = secondary_mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
}