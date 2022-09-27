package com.regmovies.qa.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.regmovies.qa.base.BaseClass;
import com.regmovies.qa.utils.LogInData;



public class LogInDataTest extends BaseClass {
	
	@DataProvider(name = "logInDataIterator")
	public Iterator<LogInData> autoDataIterator() {
		List<LogInData> list = new ArrayList<LogInData>();
		LogInData logData1 = new LogInData("Regal - Log In", "Log in to Regal Crown Club", "wick@420", "123",
				"Bad user name or password.");
		LogInData logData2 = new LogInData("Regal - Log In", "Log in to Regal Crown Club", "johnny@420", "456",
				"Bad user name or password.");
		list.add(logData1);
		list.add(logData2);
		return list.iterator();
	}
	
	@DataProvider(name = "logINDataObject")
	public Object[][] autoDataObject() {
		LogInData logData1 = new LogInData("Regal - Log In", "Log in to Regal Crown Club", "wick@420", "123",
				"Bad user name or password.");
		LogInData logData2 = new LogInData("Regal - Log In", "Log in to Regal Crown Club", "johnny@420", "456",
				"Bad user name or password.");
		return new Object[][] {{logData1}, {logData2}};
		
	}
	
	
	@Test(enabled = true, dataProvider = "logInDataIterator") 
	public void logInBadCredentialsDataTest(LogInData logData) {
		homePage.homeLogInStep();
		logInPage.logInWithBadCredentials(logData);
	}
	

}
