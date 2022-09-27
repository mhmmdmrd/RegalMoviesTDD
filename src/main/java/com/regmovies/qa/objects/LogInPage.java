package com.regmovies.qa.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.regmovies.qa.commons.CommonFunctions;
import com.regmovies.qa.utils.LogInData;

public class LogInPage {

	WebDriver driver;
	CommonFunctions commons;

	public LogInPage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

	@FindBy(tagName = "h1")
	WebElement pageHeaderElement; // Log in to Regal Crown Club

	@FindBy(xpath = "//input[@name='username']")
	WebElement emailFeildElement;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passWordElement;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginElement;

	@FindBy(className = "error_wrapper")
	WebElement errorMsgElement;

	private void verifyPageTitle(String expectedTitle) {
		assertEquals(commons.getTitle(driver), expectedTitle);
	}

	private void verifyHeader(String expectedHeader) {
		assertEquals(commons.getText(pageHeaderElement), expectedHeader);
	}

	private void inputEmail(String email) {
		commons.inputValues(emailFeildElement, email);
	}

	private void inputPassword(String passWord) {
		commons.inputValues(passWordElement, passWord);
	}

	private void clickLogIn() {
		commons.click(loginElement);
	}

	private void verifyError(String errorMsg) {
		assertEquals(commons.getText(errorMsgElement), errorMsg); // Bad user name or password.
	}

	public void logInWithBadCredentials(String expectedTitle, String expectedHeader, String email, String passWord,
			String errorMsg) {
		verifyPageTitle(expectedTitle);
		verifyHeader(expectedHeader);
		inputEmail(email);
		inputPassword(passWord);
		clickLogIn();
		verifyError(errorMsg);

	}
	
	public void logInWithBadCredentials(LogInData logData) {
		verifyPageTitle(logData.getExpectedTitle());
		verifyHeader(logData.getExpectedHeader());
		inputEmail(logData.getEmail());
		inputPassword(logData.getPassWord());
		clickLogIn();
		verifyError(logData.getErrorMsg());
	}

}