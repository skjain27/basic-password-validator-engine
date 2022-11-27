package com.development.validator.password.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.development.validator.password.rules.CharacterRule;
import com.development.validator.password.rules.PasswordLengthRule;
import com.development.validator.password.rules.PasswordLowerCaseRule;
import com.development.validator.password.rules.PasswordNumericCharacterRule;
import com.development.validator.password.rules.PasswordUpperCaseRule;

/**
 * 
 * @author skjain27
 *
 */

public class PasswordValidationEngine {

	private List<String> messages = new ArrayList<String>();
	private RuleValidationEngine ruleValidationEngine;

	public PasswordValidationEngine() {
		this.messages = new ArrayList<String>();
		ruleValidationEngine = new RuleValidationEngine(Arrays.asList(new PasswordLengthRule(),
				new CharacterRule(new PasswordUpperCaseRule()), new CharacterRule(new PasswordLowerCaseRule()),
				new CharacterRule(new PasswordNumericCharacterRule())));
	}

	/**
	 * Method to validate the password
	 * 
	 * @param password
	 */
	public boolean validate(String password) {
		ruleValidationEngine.validate(password);
		setErrorMessages(ruleValidationEngine.getErrorMessages());
		return ruleValidationEngine.isValid();

	}

	private void setErrorMessages(List<String> errorMessages) {
		this.messages = errorMessages;
	}

	/**
	 * Method to get messages
	 */
	public List<String> getErrorMessages() {
		return messages;
	}
}
