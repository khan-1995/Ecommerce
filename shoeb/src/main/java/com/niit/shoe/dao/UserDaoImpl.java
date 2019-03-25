package com.niit.shoe.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoe.model.UserValidation;



@Transactional
@Repository("users")
public class UserDaoImpl implements UserDao{

	
	@Autowired
	SessionFactory sf;
	public boolean addCreate(UserValidation user) {
		
		sf.getCurrentSession().persist(user);
		
		return true;
	}

	public UserValidation getCuserid(int cuserid) {
		// TODO Auto-generated method stub
		
		try {
			return sf.getCurrentSession().get(UserValidation.class, cuserid);
		}
		
		catch(Exception e) {
			System.out.println(""+e);
			return null;
		}
		
	}

	public List<UserValidation> retrieveAllUsers() {
		// TODO Auto-generated method stub
		
		try {
			return sf.getCurrentSession().createQuery("from UserValidation",UserValidation.class).getResultList();
		}
		
		catch(Exception e) {
			System.out.println(""+e);
			return null;
		}
	}

	public boolean delete(UserValidation user) {
		// TODO Auto-generated method stub
		try {
			sf.getCurrentSession().remove(user);
			
			return true;
		}
		catch(Exception e) {
			System.out.println(""+e);
			return false;
		}	
	}

	public boolean update(UserValidation user) {
		try {
			sf.getCurrentSession().update(user);
			return true;
			}
		catch(Exception e) {
			System.out.println(""+e);
			return false;
		  }
		}

	public UserValidation getUserDetails(String email_id) {
		// TODO Auto-generated method stub
		
		try {
			return sf.getCurrentSession().createQuery("from UserValidation where email_id = : email_id",UserValidation.class).setParameter("email_id", email_id).getSingleResult();
		}
		catch(Exception e) {
	 
			return null;
		}
	
	}	

  }

