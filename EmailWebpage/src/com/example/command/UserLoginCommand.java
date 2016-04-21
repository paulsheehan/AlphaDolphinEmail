package com.example.command;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;
import com.example.service.UserService;

public class UserLoginCommand implements Command{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
			
		UserService userService = new UserService();
		
		String forwardToJsp = "";	

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		//Check we have a username and password...
		if (email != null && password != null){
			
			//Make call to the 'Model' using the UserServive class to login...
			User userLoggingIn = userService.login(email, password);
			

			if (userLoggingIn != null){
				//If login successful, store the session id for this client...
				HttpSession session = request.getSession();
				String clientSessionId = session.getId();
				session.setAttribute("loggedSessionId", clientSessionId);

				session.setAttribute("user", userLoggingIn);

				forwardToJsp = "/viewInbox.jsp";
			}else{
				forwardToJsp = "/loginFailure.jsp";	
			}
		}
		else {
			forwardToJsp = "/loginFailure.html";	
		}
		
		System.out.println("UserLogin");
		
		return forwardToJsp;
	}
	
}