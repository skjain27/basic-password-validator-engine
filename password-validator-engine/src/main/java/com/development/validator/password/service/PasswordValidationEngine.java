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
	 * Method to validate the length of the password
	 * @param password
	 */
	public boolean validate(String password) {
		if(password.isEmpty())
			return false;
		if(password.length()<8) {
			messages.add("Password should be of atleast 8 characters");
			return false;
		}
		return true;
			
	}
	
	/**
	 * Method to get messages
	 */
	public List<String> getErrorMessages(){
		return messages;
	}
}