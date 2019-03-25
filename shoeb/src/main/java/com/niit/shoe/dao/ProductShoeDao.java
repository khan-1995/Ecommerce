package com.niit.shoe.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.niit.shoe.model.Category;
import com.niit.shoe.model.Product;


@Component
public interface ProductShoeDao {

	 public boolean addCreate(Product psd);
	 
	 public Product getProductid(int productid );
	 public boolean update(Product ps);
	 public List<Product> retrievedAllData();
	 public boolean delete(Product ps);
//	 
	 
	

}
