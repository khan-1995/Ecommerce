package com.niit.shoe.testcase;



import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoe.dao.UserDao;
import com.niit.shoe.db_configuration.HibernateConfiguration;
import com.niit.shoe.model.UserValidation;


public class TestUser {
 AnnotationConfigApplicationContext context;
 UserValidation user;
 UserDao userd;	
	
 
 @Before
 public void init() {
	 context = new  AnnotationConfigApplicationContext(HibernateConfiguration.class);
	userd = (UserDao)context.getBean("users");
	user = new UserValidation();
	 
 }
	
	@Test
	public void test() {
	
	}

}