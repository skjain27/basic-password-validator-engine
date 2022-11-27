package com.development.validator.password.rules;

import java.util.Optional;

import com.development.validator.password.handler.constants.ValidationConstants;
import com.development.validator.password.handler.interfaces.PasswordValidationRule;

/**
 * 
 * @author skjain27
 *
 */
public class PasswordLowerCaseRule implements PasswordValidationRule {

	@Override
	public Optional<String> validate(String password) {
		if (!password.chars().anyMatch(p -> Character.isLetter(p) && Character.isLowerCase(p))) {
			return Optional.of(ValidationConstants.PASSWORD_LOWERCASE_MISMATCH);
		}
		return Optional.empty();
	}

}
