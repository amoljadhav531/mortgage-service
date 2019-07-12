package com.hcl.mortgage.exception;

/**
 * PINCodeNotFoundException is custom exception created for PIN code not found validation
 * @author amol.jadhav
 */
public class PINCodeNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public PINCodeNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
