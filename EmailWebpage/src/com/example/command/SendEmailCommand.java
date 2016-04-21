package com.example.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmailCommand implements Command {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
	      // Sender's email ID needs to be mentioned
	      String from = "teamalphadolphins@gmail.com";
	      final String username = "teamalphadolphins";//change accordingly
	      final String password = "postmanDolphin";//change accordingly
	      
	      // Recipient's email ID needs to be mentioned.
	      String receipient = request.getParameter("receipient");
	      String subject = request.getParameter("subject");;
	      String content = request.getParameter("content");;

//	      Part filePart;
//	      try {
//			filePart = request.getPart("file");
//		} catch (IllegalStateException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (ServletException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	      
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
	                    InternetAddress.parse(receipient));
	     	
	     	   // Set Subject: header field
	     	   message.setSubject(subject);
	     	
//	     	  // Create the message part 
//	           BodyPart messageBodyPart = new MimeBodyPart();
//	           
	     	   // Now set the actual message
	     	   message.setText(content);
//	     	   
//	     	  // Create a multipart message
//	           Multipart multipart = new MimeMultipart();
//
//	           // Set text message part
//	           multipart.addBodyPart(messageBodyPart);

	           // Part two is attachment
//	           messageBodyPart = new MimeBodyPart();
//	           String filename = filePart.getName();
//	           DataSource source = new FileDataSource((File) filePart);
//	           messageBodyPart.setDataHandler(new DataHandler(source));
//	           messageBodyPart.setFileName(filename);
//	           multipart.addBodyPart(messageBodyPart);

//	           // Send the complete message parts
//	           message.setContent(multipart );

	     	   // Send message
	     	   Transport.send(message);

	     	   
	     	   System.out.println("Sent message successfully....");

	           } catch (MessagingException e) {
	              throw new RuntimeException(e);
	           }
	        
	        //Directs to another page after the email is sent
	        String forwardToJsp = new String("/viewInbox.jsp");
	        return forwardToJsp;
	}
	
}
