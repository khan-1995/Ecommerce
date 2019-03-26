package com.niit.shoe.dao;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoe.model.Category;


@Transactional
@Repository("catdao")
public class CategoryDaoImpl implements CategoryDao 
{

	@Autowired
	SessionFactory sf;
	public boolean addCreate(Category cat) 
	{
	
		try {
			sf.getCurrentSession().save(cat);
			return true;
		}
		catch(Exception e) 
		{
			System.out.println(""+e);
			return false;
			
		}	
		
		
	}

	
	public Category getCateogary_id(int cateogaryid) {
        
		try {
		 return sf.getCurrentSession().get(Category.class,cateogaryid);
		 
	}
		
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;			   
        }
		

	
	}


	public List<Category> retrievedAllData() {

		try {
			return sf.getCurrentSession().createQuery("from Category",Category.class).getResultList();
		}
		
		catch (Exception e) {
		System.out.println(""+e);
			return null;
		}
		
	}


	public boolean update(Category cat) {
		
		try {
			sf.getCurrentSession().update(cat);
			return true;
		}
		
		catch(Exception e){
			System.out.println(""+e);
		return false;
		}
	}


	public boolean delete(Category cat) {
	
		try {
			sf.getCurrentSession().remove(cat);
			return true;
		
		}
		catch(Exception e){
			System.out.println(""+e);
		return false;
		}
	}


	public Category getCategory(int categoryid) {
		try {
			 return sf.getCurrentSession().get(Category.class,categoryid);
			 
		}
			
			catch(Exception ex)
			{
				System.out.println(ex);
				return null;			   
	        }
			

	}
		
		

}
	