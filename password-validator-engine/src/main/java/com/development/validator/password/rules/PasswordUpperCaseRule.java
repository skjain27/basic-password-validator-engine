package com.development.validator.password.rules;

import java.util.Optional;

import com.development.validator.password.handler.constants.ValidationConstants;
import com.development.validator.password.handler.interfaces.PasswordValidationRule;

/**
 * 
 * @author skjain27
 *
 */
public class PasswordUpperCaseRule implements PasswordValidationRule {

	@Override
	public Optional<String> validate(String password) {

		if (!password.chars().anyMatch(p -> Character.isLetter(p) && Character.isUpperCase(p))) {
			return Optional.of(ValidationConstants.PASSWORD_UPPERCASE_MISMATCH);
		}
		return Optional.empty();
	}

}
