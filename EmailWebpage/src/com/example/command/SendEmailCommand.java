package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailCommand implements Command {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
	      // Sender's email ID needs to be mentioned
	      String from = "teamalphadolphins@gmail.com";
	      final String username = "teamalphadolphins";//change accordingly
	      final String password = "postmanDolphin";//change accordingly
	      
	      // Recipient's email ID needs to be mentioned.
	      String to = "p.sheehan94@gmail.com";
	      String subject = "Testing Subject";
	      String content = "Hello, this is sample for to check send email using JavaMailAPI ";
	      
	      HttpSession hSesh = request.getSession();
	      
	      //hSesh.getAttribute(arg0)
	      
	      
	      
	      //Emails get sent through Gmails SMTP server
	      String host = "smtp.gmail.com";
	      
	      Properties props = new Properties();
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", password);
	        props.put("mail.smtp.port", "25");
	        props.put("mail.smtp.auth", "true");

	        Session session = Session.getInstance(props,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });
	        
	        //Structures and then sends the email
	        try {
	     	   // Create a default MimeMessage object.
	     	   Message message = new MimeMessage(session);
	     	
	     	   // Set From: header field of the header.
	     	   message.setFrom(new InternetAddress(from));
	     	
	     	   // Set To: header field of the header.
	     	   message.setRecipients(Message.RecipientType.TO,
	                    InternetAddress.parse(to));
	     	
	     	   // Set Subject: header field
	     	   message.setSubject(subject);
	     	
	     	   // Now set the actual message
	     	   message.setText(content);

	     	   // Send message
	     	   Transport.send(message);

	     	   System.out.println("Sent message successfully....");

	           } catch (MessagingException e) {
	              throw new RuntimeException(e);
	           }
	        
	        //Directs to another page after the email is sent
	        String forwardToJsp = new String("MainPage.html");
	        return forwardToJsp;
	}
	
}
