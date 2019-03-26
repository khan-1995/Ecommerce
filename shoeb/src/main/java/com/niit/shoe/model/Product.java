package com.niit.shoe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

@Entity                                                            
public class Product  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  productid;
	
	@OneToOne
	private Category category;
    
	
	  @NotNull(message = "Please fill this field")  
	  @NotEmpty(message = "Please fill this field")
	  private String productname;
	
	
	  @NotNull(message = "Please fill this field")
	  @NotEmpty(message = "Please fill this field") 
      private String productdesc;
	
	
	/* @Pattern(regexp = "[0-9]", message = "Only digits are accepted") */
	  
	  @NotNull(message = "Please fill this field")
	 // @NotEmpty(message = "Please fill this field")
	  private float productprice;

	  @Transient
	  private MultipartFile image;
	
	public MultipartFile getImage() {
		return image;
	}


	public void setImage(MultipartFile image) {
		this.image = image;
	}


	


	/* @Pattern(regexp = "[0-9]", message = "Only digits are accepted") */
	@NotNull(message = "Please fill this field")
	//@NotEmpty(message = "Please fill this field")
	private int productstock;
	
	
	
	public int getProductid() {
		return productid;
	}
    
    
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
	public float getProductprice() {
		return productprice;
	}
	public void setProductprice(float productprice) {
		this.productprice = productprice;
	}
	

	public int getProductstock() {
		return productstock;
	}


	public void setProductstock(int productstock) {
		this.productstock = productstock;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	
	
	
	
}