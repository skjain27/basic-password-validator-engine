package com.development.validator.password.handler.interfaces;

import java.util.function.IntPredicate;

/**
 * 
 * @author skjain27
 *
 */

public interface CharacterCheckPredicate {

	public IntPredicate getPredicate();

	public String getErrorMessage();

}
