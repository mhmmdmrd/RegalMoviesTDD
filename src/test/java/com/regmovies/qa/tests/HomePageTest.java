package com.regmovies.qa.tests;

import org.testng.annotations.Test;

import com.regmovies.qa.base.BaseClass;

public class HomePageTest extends BaseClass{

	@Test
	public void homeVerifyTests() {
		homePage.homePageSteps("Movie Showtimes & Movie Tickets | Regal Theatres", "Now Playing", "Coming Soon");
	}
}
