package com.development.validator.password.handler.interfaces;

import java.util.Optional;

/**
 * 
 * @author skjain27
 *
 */

public interface PasswordValidationRule {
	
	public Optional<String> validate(String password);

}
