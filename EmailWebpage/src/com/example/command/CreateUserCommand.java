package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserCommand implements Command{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		String forwardToJsp = "/MainPage.html";
		
		String userEmail = request.getParameter("userEmail");
		
		System.out.println(userEmail);
		return forwardToJsp;
	}
	
}
