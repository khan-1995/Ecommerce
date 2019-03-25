package com.niit.shoe.dao;

import java.util.List;

import com.niit.shoe.model.UserValidation;



public interface UserDao {
	
	
	public boolean addCreate(UserValidation user);
	public UserValidation getCuserid(int cuserid);
	public List<UserValidation> retrieveAllUsers();
	public UserValidation getUserDetails(String email_id);
	public boolean delete(UserValidation user);
	public boolean update(UserValidation user);

}