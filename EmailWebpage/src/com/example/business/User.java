package com.example.business;

import java.io.Serializable;

public class User implements Serializable{


	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	
	
	public User( String email, String password) {
		System.out.println("PASS" + password);
		
		setEmail(email);
		setPassword(password);
	}	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
