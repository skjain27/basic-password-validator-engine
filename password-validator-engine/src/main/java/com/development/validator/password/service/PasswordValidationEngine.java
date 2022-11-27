package com.development.validator.password.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author skjain27
 *
 */

public class PasswordValidationEngine {

	private List<String> messages = new ArrayList<String>();

	/**
	 * Method to validate the length & emptiness of the password
	 * 
	 * @param password
	 */
	public boolean validate(String password) {
		
		if (password == null || password.isEmpty()) {
			messages.add("Password is Empty or Null");
			return false;
		}

		if (password.length() < 8) {
			messages.add("Password should be of atleast 8 characters");
			return false;
		}
		
		if(!password.chars().anyMatch(p->Character.isLetter(p) && Character.isUpperCase(p))) {
			messages.add("Password should have atleast one upper case character");
			return false;
		}
		
		if(!password.chars().anyMatch(p->Character.isLetter(p) && Character.isLowerCase(p))) {
			messages.add("Password should have atleast one lower case character");
			return false;
		}
		
		if(!password.chars().anyMatch(p->Character.isDigit(p))) {
			messages.add("Password should have atleast one numeric character");
			return false;
		}
		
		return true;

	}

	/**
	 * Method to get messages
	 */
	public List<String> getErrorMessages() {
		return messages;
	}
}
