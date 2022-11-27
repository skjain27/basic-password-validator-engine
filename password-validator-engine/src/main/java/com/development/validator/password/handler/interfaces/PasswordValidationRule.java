package com.development.validator.password.handler.interfaces;

import java.util.Optional;

import com.development.validator.password.handler.enums.ValidationRulesType;

/**
 * 
 * @author skjain27
 *
 */

public interface PasswordValidationRule {
	
	public Optional<String> validate(String password);
	public ValidationRulesType getValidationRuleType();

}
