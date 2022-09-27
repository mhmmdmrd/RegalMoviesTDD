package com.regmovies.qa.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.regmovies.qa.commons.CommonFunctions;


public class HomePage {

	WebDriver driver;
	CommonFunctions commons;

	public HomePage(WebDriver driver, CommonFunctions commons ) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}
	
	@FindBy(css = "img.img-responsive.main-logo")
	WebElement logoElement;
	
	@FindBy(xpath = "//h2[text()='Now Playing']")
	WebElement nowPlayingElement;
	
	@FindBy(xpath = "//h2[text()='Coming Soon']")
	WebElement comingSoonElement;
	
	@FindBy(xpath = "//a[@title='Current Promotions']")
	WebElement promoElement;
	
	@FindBy(css = "img.user-icon")
	WebElement userIconElement;
	
	private void getPageTitle(String expectedTitle) {
		assertEquals(commons.getTitle(driver), expectedTitle);
		//Movie Showtimes &amp; Movie Tickets | Regal Theatres
	}
	
	private void verifyLogo() {
		commons.isDisplayed(logoElement);
		}
	
	private void verifyNowPlayingText(String expectedText1) {
		assertEquals(commons.getText(nowPlayingElement), expectedText1);
	}
	
	private void verifyComingSoonText(String expectedText2) {
		assertEquals(commons.getText(comingSoonElement), expectedText2);
	}
	
	private void clickPromo() {
		commons.click(promoElement);
	}
	
	private void clickUserIcon() {
		commons.click(userIconElement);
	}
	
	public void homePageSteps(String expectedTitle, String expectedText1, String expectedText2) {
		getPageTitle(expectedTitle);
		verifyLogo();
		verifyNowPlayingText(expectedText1);
		verifyComingSoonText(expectedText2);
	}
	
	public void homePromoStep() {
		verifyLogo();
		clickPromo();
	}
	
	public void homeLogInStep() {
		verifyLogo();
		clickUserIcon();
		
	}
	
	
}
