package com.development.validator.password.rules;

import java.util.Optional;
import java.util.stream.IntStream;

import com.development.validator.password.handler.interfaces.CharacterCheckPredicate;
import com.development.validator.password.handler.interfaces.PasswordValidationRule;

/**
 * 
 * @author skjain27
 *
 */
public class CharacterRule implements PasswordValidationRule {

	private CharacterCheckPredicate characterCheckPredicate;

	public CharacterRule(CharacterCheckPredicate ch) {
		this.characterCheckPredicate = ch;
	}

	@Override
	public Optional<String> validate(String password) {
		try (IntStream chStream = password.chars()) {
			if (!chStream.anyMatch(characterCheckPredicate.getPredicate()))
				return Optional.of(characterCheckPredicate.getErrorMessage());
		} catch (NullPointerException ne) {
			return Optional.of(characterCheckPredicate.getErrorMessage());
		}
		return Optional.empty();
	}

}
