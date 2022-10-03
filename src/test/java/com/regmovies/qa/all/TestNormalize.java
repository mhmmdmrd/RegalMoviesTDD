package com.regmovies.qa.all;

import org.testng.annotations.Test;

import com.regmovies.qa.base.BaseClass;

public class TestNormalize extends BaseClass{
	
	@Test(groups = "home")
	public void homeVerifyTests() {
		homePage.homePageSteps("Movie Showtimes & Movie Tickets | Regal Theatres", "Now Playing", "Coming Soon");
	}

	@Test(groups = {"promo", "login"})

public void verifyPromoTest() {
	homePage.homePromoStep();
	promoPage.promoSteps("https://www.regmovies.com/static/en/us/promotions", "Specials & Promotions",
			"Unlimited Movie Subscription", "Regal Unlimited™ Movie Subscription Pass");
}

	@Test(groups = "login")
	public void testLogInWithBadCredentials() {
		homePage.homeLogInStep();
		logInPage.logInWithBadCredentials("Regal - Log In", "Log in to Regal Crown Club", "wick@420", "123",
				"Bad user name or password.");
	}
}
