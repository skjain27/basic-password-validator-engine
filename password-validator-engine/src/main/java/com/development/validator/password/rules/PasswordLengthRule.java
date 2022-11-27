package com.development.validator.password.rules;

import java.util.Optional;

import com.development.validator.password.handler.constants.ValidationConstants;
import com.development.validator.password.handler.interfaces.PasswordValidationRule;

/**
 * 
 * @author skjain27
 *
 */

public class PasswordLengthRule implements PasswordValidationRule {

	/**
	 * Validates Length mismatch
	 * 
	 * @param password
	 */
	@Override
	public Optional<String> validate(String password) {

		if (password == null || password.isEmpty())
			return Optional.of(ValidationConstants.PASSWORD_NULL);

		if (password.length() < 8)
			return Optional.of(ValidationConstants.PASSWORD_LENGTH_MISMATCH);

		return Optional.empty();
	}

}
