package com.example.thallescezar.myapplication;

public class EmailNode {

	private String message;
	private EmailNode next;
	
	public EmailNode (String message) {
		this.message = message;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the next
	 */
	public EmailNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public void setNext(EmailNode next) {
		this.next = next;
	}
}
