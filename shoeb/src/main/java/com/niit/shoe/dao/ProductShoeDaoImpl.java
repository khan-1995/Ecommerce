package com.niit.shoe.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoe.model.Category;
import com.niit.shoe.model.Product;


@Transactional
@Repository("productdao")
public class ProductShoeDaoImpl implements ProductShoeDao {

    
	@Autowired
	SessionFactory sf;
	public boolean addCreate(Product ps) {
		
		try {
			sf.getCurrentSession().save(ps);
			return true;			
		}
		
		catch(Exception e) {
			System.out.println(""+e);
			return false;
		}
		
	}
	public Product getProductid(int productid) {
		try {
			
			return sf.getCurrentSession().get(Product.class, productid);
		}
		
		catch(Exception e){
			return null;
		}
		
	}
	public boolean update(Product ps) {
		try {
			 sf.getCurrentSession().update(ps);
			 return true;
		}
		
		catch(Exception e) {
			System.out.println(" "+e);
			return false;
		}
		
	}
	public List<Product> retrievedAllData() {
		try {
			return sf.getCurrentSession().createQuery("from Product",Product.class).getResultList();
		}
		
		catch(Exception e) {
			System.out.println(" "+e);
			return null;
		}
		
		
		
	}
	public boolean delete(Product ps) {
		try {
			sf.getCurrentSession().remove(ps);
			return true;
		
		}
		catch(Exception e){
			System.out.println(""+e);
		return false;
		}
	}

	
}