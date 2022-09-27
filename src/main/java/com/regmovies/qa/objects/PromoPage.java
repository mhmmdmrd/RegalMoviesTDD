package com.regmovies.qa.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.regmovies.qa.commons.CommonFunctions;

public class PromoPage {

	WebDriver driver;
	CommonFunctions commons;

	public PromoPage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

@FindBy(xpath = "//h1[text()='Specials & Promotions']")
 WebElement promotionTextElement;

@FindBy(xpath = "//h3[text()='Unlimited Movie Subscription']")
WebElement unlimitedMoviesTextElement;

@FindBy(xpath="(//a[@title='Learn More'])[1]")
WebElement unlimitedMoviesLearnButton;

@FindBy(tagName = "h1" ) //Regal Unlimited™ Movie Subscription Pass
WebElement regalUnlimitedTextElement;

@FindBy(css="img.img-responsive.hidden-xs")
WebElement regalUnlimitedImageElement;


private void getCurrentUrl(String url ) {// https://www.regmovies.com/static/en/us/promotions
	assertEquals(commons.getCurrentUrl(driver), url);
}

private void  verifyPromoText(String subTitle1) {
 assertEquals(commons.getText(promotionTextElement), subTitle1);
 
}

private void verifyUnlimitedMovieText(String subTitle2) {
	assertEquals(commons.getText(unlimitedMoviesTextElement), subTitle2);
}
private void clickLearnMoreUnlimited() {
	commons.click(unlimitedMoviesLearnButton);
}

private void verifyRegalUnlimitedPromo(String subTitle3) {
	assertEquals(commons.getText(regalUnlimitedTextElement), subTitle3);
}

private void verifyRegalPromoImage() {
	commons.isDisplayed(regalUnlimitedImageElement);
}

public void promoSteps(String url, String subTitle1, String subTitle2, String subTitle3) {
	getCurrentUrl(url);
	verifyPromoText(subTitle1);
	verifyUnlimitedMovieText(subTitle2);
	clickLearnMoreUnlimited();
	verifyRegalUnlimitedPromo(subTitle3);
	verifyRegalPromoImage();
	
}
}

