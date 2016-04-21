package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UserDao;
import com.example.exceptions.DaoException;

public class CreateUserCommand implements Command{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		String forwardToJsp = "/index.html";
		
		String userEmail = request.getParameter("userEmail");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		String answer = request.getParameter("answer");
		
		UserDao user = new UserDao();
		try {
			user.addUserToDatabase(userEmail, fullName, password, answer);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(userEmail);
		return forwardToJsp;
	}
	
}
