package com.example.service;

import com.example.business.User;
import com.example.dao.UserDao;
import com.example.exceptions.DaoException;

public class UserService {

	UserDao dao = new UserDao();
	
	public User login(String email, String password){
		
		User u = null;
		try {			
			u = dao.findUserByUsernamePassword(email, password);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return u;
		
	}
}