package com.development.validator.password.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author skjain27
 *
 */

public class BasicValidatorPasswordTest {
	
	private PasswordValidationEngine passwordValidationEngine;
	/**
	 * This method will be executed at the beginning of the unit test execution
	 */
	@BeforeClass
	public void initTesting() {
		System.out.println("Started Unit Testing for Password Validation");
		passwordValidationEngine=new PasswordValidationEngine();
	}

	/**
	 * This method will be executed at the beginning of every test case
	 */
	@Before
	public void beforeEachTest() {
		System.out.println("Start Running test cases...");
	}

	/**
	 * This method will be executed at the end of every test case
	 */
	@After
	public void afterTest() {
		System.out.println("Tests Executed Successfully.");
	}

	/**
	 * This method is used to test the password for invalid length
	 */
	@Test
	public void testInvalidPasswordLength() {
		assertFalse(passwordValidationEngine.validate("1234"));
		assertThat(passwordValidationEngine.getErrorMessages(), hasItem("Password should be of atleast 8 characters"));
	}

	/**
	 * This method is used to test the password for Minimum length
	 */
	@Test
	public void testValidMinimumPasswordLength() {
		assertTrue(passwordValidationEngine.validate("12345Wa678"));
		assertThat(passwordValidationEngine.getErrorMessages(),
				not(hasItem("Password should be of atleast 8 characters")));
	}

	/**
	 * This method is used to test the password for any length above minimum length
	 */
	@Test
	public void testValidPasswordLength() {
		assertTrue(passwordValidationEngine.validate("12345Wa678"));
		assertThat(passwordValidationEngine.getErrorMessages(),
				not(hasItem("Password should be of atleast 8 characters")));
	}

	/**
	 * This method is used to test the password for null
	 */
	@Test
	public void testNullPassword() {
		assertFalse(passwordValidationEngine.validate(null));
		assertThat(passwordValidationEngine.getErrorMessages(), hasItem("Password is Empty or Null "));
	}

	/**
	 * This method is used to test the password for empty
	 */
	@Test
	public void testEmptyPassword() {
		assertFalse(passwordValidationEngine.validate(""));
		assertThat(passwordValidationEngine.getErrorMessages(), hasItem("Password is Empty or Null "));
	}

	/**
	 * This method is used to test the password for non null check
	 */
	@Test
	public void testNonEmptyPassword() {
		assertTrue(passwordValidationEngine.validate("1224Wa3231"));
		assertThat(passwordValidationEngine.getErrorMessages(), not(hasItem("Password is Empty or Null ")));
	}
	
	/**
	 * This method is used to test the password for atleast one upper case letter
	 */
	@Test
	public void testNoUpperCasePassword() {
		assertFalse(passwordValidationEngine.validate("12243a231"));
		assertThat(passwordValidationEngine.getErrorMessages(), hasItem("Password should have atleast one upper case character"));
	}
	
	/**
	 * This method is used to test the password for atleast one upper case letter
	 */
	@Test
	public void testUpperCasePassword() {
		assertTrue(passwordValidationEngine.validate("12W43a231"));
		assertThat(passwordValidationEngine.getErrorMessages(), not(hasItem("Password should have atleast one upper case character")));
	}
	
	/**
	 * This method is used to test the password for atleast one lower case letter
	 */
	@Test
	public void testNoLowerCasePassword() {
		assertFalse(passwordValidationEngine.validate("122W43231"));
		assertThat(passwordValidationEngine.getErrorMessages(), hasItem("Password should have atleast one lower case character"));
	}
	
	/**
	 * This method is used to test the password for atleast one lower case letter
	 */
	@Test
	public void testLowerCasePassword() {
		assertTrue(passwordValidationEngine.validate("12aW43231"));
		assertThat(passwordValidationEngine.getErrorMessages(), not(hasItem("Password should have atleast one lower case character")));
	}
	
	/**
	 * This method is used to test the password for atleast one numeric character
	 */
	@Test
	public void testNoNumericPassword() {
		assertFalse(passwordValidationEngine.validate("passworWd"));
		assertThat(passwordValidationEngine.getErrorMessages(), hasItem("Password should have atleast one numeric character"));
	}
	
	/**
	 * This method is used to test the password for atleast one numeric letter
	 */
	@Test
	public void testPasswordWithNumeric() {
		assertTrue(passwordValidationEngine.validate("12aW43231"));
		assertThat(passwordValidationEngine.getErrorMessages(), not(hasItem("Password should have atleast one numeric character")));
	}
	
	@Test
	public void testThreeConditions() {
		assertTrue(passwordValidationEngine.validate("123Pa"));
	}
}
