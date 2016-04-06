package com.example.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.command.Command;
import com.example.command.CommandFactory;
import com.example.exceptions.CommandCreationException;

@WebServlet(name ="front", urlPatterns={"/FrontController"})
@MultipartConfig

public class FrontController extends HttpServlet{

	public static final long serialVersionUID = 1L;
	public static final String LOGIN_ACTION = "UserIsWelcomed";
	
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest (request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest (request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
	{
		
		String forwardToJsp = new String("/MainPage.html");
		String action = request.getParameter("action");
		System.out.println(action);
//		if ( !action.equalsIgnoreCase(LOGIN_ACTION) ){
//
//			//If not a login request then need to check that user is  
//			//logged in before processing ANY requests.
//			
//			//Check to see if the session id coming from the client matches the id stored at login...
//			HttpSession session = request.getSession();
//
//			//If user not logged in...
//			if ( session.getId() != session.getAttribute("loggedSessionId") ){
//				forwardToJsp = "/loginFailure.jsp";
//				forwardToPage(request, response, forwardToJsp);
//				return;
//			}			
//		}
		
		//Now we can process whatever the request is...
		//We just create a Command object to handle the request...
		CommandFactory factory = CommandFactory.getInstance();
		Command command = null;
		
		try {
			command = factory.createCommand(action);
			forwardToJsp = command.execute(request, response);
		} catch (CommandCreationException e) {			
			e.printStackTrace();
			forwardToJsp = "/errorPage.jsp";
		}		
		
		forwardToPage(request, response, forwardToJsp);
	}
	
	private void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page)
	{
		//Get the request dispatcher object and forward the request to the appropriate JSP page...
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
				try {
					dispatcher.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
}
