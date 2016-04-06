package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginCommand implements Command{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		String forwardToJsp = "/index.html";
		
		System.out.println("UserLogin");
		return forwardToJsp;
	}
	
}