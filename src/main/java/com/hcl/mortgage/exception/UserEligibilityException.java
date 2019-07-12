package com.hcl.mortgage.exception;

/**
 * UserEligibilityException is custom exception created for user eligibility validation
 * @author amol.jadhav
 */
public class UserEligibilityException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public UserEligibilityException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
