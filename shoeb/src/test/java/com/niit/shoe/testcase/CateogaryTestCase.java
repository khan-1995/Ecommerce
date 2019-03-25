package com.niit.shoe.testcase;


import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.shoe.db_configuration.HibernateConfiguration;
import org.junit.Before;
public class CateogaryTestCase {

	AnnotationConfigApplicationContext context;

	@Before
	public void init() {
		context=new  AnnotationConfigApplicationContext(HibernateConfiguration.class);
	}
	
	@Test
	public void test() {
	
	}


}