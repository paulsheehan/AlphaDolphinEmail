package com.example.command;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPMessage;
import com.example.business.Email;

public class ShowEmailsCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
    	
    	String forwardToJsp = "/viewInbox.jsp";
    	
    	Properties props = System.getProperties();
    	props.setProperty("mail.store.protocol", "imaps");
    	IMAPFolder folder = null;
		String subject = null;
		 
    	try {
    		
    	  Session session = Session.getDefaultInstance(props, null);
    	 
    	  Store store = session.getStore("imaps");
       	  store.connect("imap.gmail.com", "teamalphadolphins@gmail.com", "postmanDolphin");
    	  folder = (IMAPFolder) store.getFolder("inbox");
    	  
    	  if(!folder.isOpen())
              folder.open(Folder.READ_WRITE);
    	  
              Message[] messages = folder.getMessages();
              

              Email[] emails = new Email[messages.length];
              
              System.out.println("No of Messages : " + folder.getMessageCount());
              System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
              System.out.println(messages.length);
              request.setAttribute("inbox", messages.length); 
              for (int i=0; i < messages.length;i++) 
              {
            	  Message msg =  messages[i];
            	  emails[i] = new Email(msg.getSubject(), msg.getFrom()[0], msg.getAllRecipients()[0], msg.getReceivedDate(), msg.getSize());
//            	  System.out.println("*****************************************************************************");
//                //System.out.println(msg.getMessageNumber());
//                //Object String;
//                //System.out.println(folder.getUID(msg)
            	  System.out.println("Subject: " + emails[i].getSubject());
            	  System.out.println("From: " + emails[i].getFrom());
               System.out.println("To: "+emails[i].getTo());
                System.out.println("Date: "+emails[i].getFromRecievedDate());
                System.out.println("Size: "+emails[i].getSize());
            	  
            	  
                try {
					System.out.println("Body: \n"+ msg.getContent());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
              }

              //request.setAttribute("emails", emails);
            }
    	 catch (NoSuchProviderException e) {
       	  e.printStackTrace();
       	  System.exit(1);
       	} catch (MessagingException e) {
       	  e.printStackTrace();
       	  System.exit(2);
       	}
            finally 
            {
              if (folder != null && folder.isOpen()) { try {
				folder.close(true);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} }
              //if (store != null) { store.close(); }
            }
    	
    		return forwardToJsp;
    	
    	}
    
    

    }

