package com.niit.shoe.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryid;
	
	
	
	@NotNull(message = "category name can not be null")
	@NotEmpty(message = "category name can not be empty")
	/*
	 * @Pattern(regexp = "[a-zA-Z]{0,9}", message = "please enter numbers 0 to 9")
	 */
	private String categoryname;
	
	@NotNull(message = "category description can not be null")
	@NotEmpty(message = "category description can not be empty")
	/* @Pattern(regexp = "[a-zA-Z]", message = "please check your description") */
	private String categorydescription;

    @OneToMany(fetch=FetchType.EAGER,mappedBy="category")
	private Collection<Product> cps = new ArrayList<Product>();

	public int getcategoryid() {
		return categoryid;
	}

	public void setcategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getcategoryname() {
		return categoryname;
	}

	public void setcategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getcategorydescription() {
		return categorydescription;
	}

	public void setcategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}
	
	
	

}
