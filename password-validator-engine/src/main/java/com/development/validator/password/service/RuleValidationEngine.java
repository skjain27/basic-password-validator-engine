package com.development.validator.password.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.development.validator.password.handler.enums.ValidationRulesType;
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
	private AtomicInteger validCount;
	private Boolean valid;
	private Boolean mandatoryRuleFailure = false;

	public RuleValidationEngine(List<PasswordValidationRule> ruleList) {
		this.ruleList = ruleList;
		this.errorMessages = new ArrayList<>();
		this.validCount = new AtomicInteger(0);
		this.valid = true;
	}

	public void validate(String password) {
		if (ruleListPresent()) {
			List<Runnable> rules = new ArrayList<>();
			for (PasswordValidationRule r : ruleList) {
				Runnable rule=()-> execute(r, password);
				rules.add(rule);
			}
			new RulesExecutionService().executeRules(rules);
			setValid(criteriaSatisfied());
		}
	}

	public void execute(PasswordValidationRule r, String password) {
		Optional<String> errorMessage = r.validate(password);
		if (errorMessage.isPresent())
			errorMessages.add(errorMessage.get());
		if (r.getValidationRuleType().equals(ValidationRulesType.MANDATORY))
			setMandatoryRuleFailure();
		else
			incrementValidCount();
	}

	private void setMandatoryRuleFailure() {
		mandatoryRuleFailure = true;
	}

	private void setValid(Boolean criteriaSatisfied) {
		this.valid = criteriaSatisfied;
	}

	private Boolean criteriaSatisfied() {
		return ((validCount.get() > 2) && !mandatoryRuleFailure);
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	private void incrementValidCount() {
		validCount.incrementAndGet();
	}

	public Boolean isValid() {
		return valid;
	}

	private boolean ruleListPresent() {
		return (ruleList != null && !ruleList.isEmpty());
	}

}
