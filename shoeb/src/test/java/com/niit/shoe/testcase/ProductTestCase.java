package com.niit.shoe.testcase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoe.dao.CategoryDao;
import com.niit.shoe.dao.ProductShoeDao;
import com.niit.shoe.db_configuration.HibernateConfiguration;
import com.niit.shoe.model.Category;
import com.niit.shoe.model.Product;

import junit.framework.Assert;


public class ProductTestCase {
	
	Product ps;
	ProductShoeDao psd;
	Category cat;
	CategoryDao catd;
	
	
	
	AnnotationConfigApplicationContext context;
	
	
	@Before
	public void init()
	{
	context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
    psd = (ProductShoeDao)context.getBean("productdao");
    ps = new Product();
    catd = (CategoryDao)context.getBean("catdao");
    
    cat = new Category();
    

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
	    cat.setcategoryname("jimmy choo");
	    cat.setcategorydescription("very expensive shoes");
	    
	    ps.setProductname("jimmy choo military");
	    ps.setProductdesc("a military shaded shoe");
	    ps.setProductprice(3400);
	    ps.setProductstock(5);
	    ps.setCategory(cat);
	    
	    Assert.assertEquals("success", true,catd.addCreate(cat));
	    Assert.assertEquals("success", true,psd.addCreate(ps));
	    
			
	}

}