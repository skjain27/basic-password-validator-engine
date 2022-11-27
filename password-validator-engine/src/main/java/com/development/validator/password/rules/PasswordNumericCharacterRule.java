package com.development.validator.password.rules;

import java.util.function.IntPredicate;

import com.development.validator.password.handler.constants.ValidationConstants;
import com.development.validator.password.handler.interfaces.CharacterCheckPredicate;

/**
 * 
 * @author skjain27
 *
 */
public class PasswordNumericCharacterRule implements CharacterCheckPredicate {

	@Override
	public IntPredicate getPredicate() {
		return (p -> Character.isDigit(p));
	}

	@Override
	public String getErrorMessage() {
		return ValidationConstants.PASSWORD_NUMERIC_MISMATCH;
	}

}
