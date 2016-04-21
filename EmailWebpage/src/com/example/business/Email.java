package com.example.business;

import java.io.Serializable;
import java.util.Date;

import javax.mail.Address;

public class Email implements Serializable{

	private static final long serialVersionUID = 1L;
	private String subject;
	private Address from;
	private Address to;
	private Date fromRecievedDate;
	private int size;
	
	
	public Email( String subject, Address from, Address to, Date date, int size) {	
		setSubject(subject);
		setFrom(from);
		setTo(to);
		setFromRecievedDate(date);
		setSize(size);
	}	
	
	public String getSubject(){
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Address getFrom() {
		return from;
	}
	public void setFrom(Address from) {
		this.from = from;
	}
	
	public Address getTo() {
		return to;
	}
	public void setTo(Address to) {
		this.to = to;
	}
	
	public Date getFromRecievedDate() {
		return fromRecievedDate;
	}
	public void setFromRecievedDate(Date date) {
		this.fromRecievedDate = date;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
