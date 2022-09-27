package com.regmovies.qa.tests;

import org.testng.annotations.Test;

import com.regmovies.qa.base.BaseClass;

public class LogInPageTest extends BaseClass {

	@Test
	public void testLogInWithBadCredentials() {
		homePage.homeLogInStep();
		logInPage.logInWithBadCredentials("Regal - Log In", "Log in to Regal Crown Club", "wick@420", "123",
				"Bad user name or password.");
	}
}
