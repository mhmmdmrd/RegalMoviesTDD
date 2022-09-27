package com.regmovies.qa.tests;

import org.testng.annotations.Test;

import com.regmovies.qa.base.BaseClass;

public class PromoPageTest extends BaseClass {

	@Test

	public void verifyPromoTest() {
		homePage.homePromoStep();
		promoPage.promoSteps("https://www.regmovies.com/static/en/us/promotions", "Specials & Promotions",
				"Unlimited Movie Subscription", "Regal Unlimited™ Movie Subscription Pass");
	}

}
