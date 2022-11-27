package com.development.validator.password.exception;

/**
 * 
 * @author skjain27
 *
 */

public class PasswordValidationException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	private Exception exception;

	public PasswordValidationException(String message) {
		this.setMessage(message);
	}

	public PasswordValidationException(Exception exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

}
