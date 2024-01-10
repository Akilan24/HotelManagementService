package com.mailservice;

public class MailNotFoundException extends RuntimeException {

	public MailNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MailNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MailNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
