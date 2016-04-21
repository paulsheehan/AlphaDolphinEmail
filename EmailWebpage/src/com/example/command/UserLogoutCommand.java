package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogoutCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		String forwardToJsp="/index.html";
		HttpSession session = request.getSession();
		session.invalidate();
		return forwardToJsp;
	}
}
