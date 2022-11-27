package com.development.validator.password.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.development.validator.password.handler.interfaces.PasswordValidationRule;
import com.development.validator.password.rules.CharacterRule;

/**
 * 
 * @author skjain27
 *
 */

public class RuleValidationEngine {

	private List<PasswordValidationRule> ruleList;
	private List<String> errorMessages;
	private Integer validCount;
	private Boolean valid;

	public RuleValidationEngine(List<PasswordValidationRule> ruleList) {
		this.ruleList = ruleList;
		this.errorMessages = new ArrayList<>();
		this.validCount = 0;
		this.valid = true;
	}

	public void validate(String password) {
		if (ruleListPresent()) {
			for (PasswordValidationRule r : ruleList) {
				Optional<String> errorMessage = r.validate(password);
				if (errorMessage.isPresent())
					errorMessages.add(errorMessage.get());
				else
					incrementValidCount();
			}
			setValid(criteriaSatisfied());
		}
	}

	private void setValid(Boolean criteriaSatisfied) {
		this.valid = criteriaSatisfied;
	}

	private Boolean criteriaSatisfied() {
		return (validCount > 2);
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	private void incrementValidCount() {
		validCount += 1;
	}

	public Boolean isValid() {
		return valid;
	}

	private boolean ruleListPresent() {
		return (ruleList != null && !ruleList.isEmpty());
	}

}
