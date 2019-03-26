package com.niit.shoe.dao;



import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.shoe.model.Category;




@Component
public interface CategoryDao {

	public boolean addCreate(Category cat);
	public Category getCateogary_id(int cateogaryid);
	public List<Category> retrievedAllData();
	public boolean update(Category cat); 
	public boolean delete(Category cat);
	public Category getCategory(int categoryid);

	
}