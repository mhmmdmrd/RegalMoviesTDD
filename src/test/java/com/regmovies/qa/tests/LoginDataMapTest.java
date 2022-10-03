package com.regmovies.qa.tests;

import java.util.Map;
import static com.regmovies.qa.utils.DataMap.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.regmovies.qa.base.BaseClass;
import com.regmovies.qa.utils.ExcelUtil;

public class LoginDataMapTest extends BaseClass {

	@DataProvider(name = "excelMap")
	public Object[][] mapData() {
		String pathString = configuration.get("excelPath");
		String sheetNameString = configuration.get("excelSheetMap");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		int size = excelUtil.dataMap().size();
		Object[][] objects2d = new Object[size][1];
		/*
		 * objects2d is an two-dimensional array Object[][] objects2d = new
		 * Object[size][1] define size = basically that many number of rows in dataMap 1
		 * = is basically each dataMap index has one map
		 */
		for (int i = 0; i < size; i++) {
			objects2d[i][0] = excelUtil.dataMap().get(i);
		}
		return objects2d;
	}

	@Test(enabled = false, dataProvider = "excelMap")
	public void logInWithBadCredentialsMapDataProvider(Map<String, String> map) {
		homePage.homeLogInStep();
		logInPage.logInWithBadCredentials(map.get("Title"), map.get("Header"), map.get("Email"), map.get("Password"),
				map.get("Error-Msg"));

	}

	@Test(enabled = true, dataProvider = "excelMap")
	public void logInWithBadCredentialsWithMap(Map<String, String> map) {
		homePage.homeLogInStep();
		logInPage.logInWithBadCredentials(map);
	}

	@Test(enabled = false, dataProvider = "excelMap")
	public void logInWithBadCredentialsWithEnumMap(Map<String, String> map) {
		homePage.homeLogInStep();
		logInPage.logInWithBadCredentials(map.get(Title.name()), map.get(Header.name()), map.get(Email.name()),
				map.get(Password.name()), map.get(ErrorMsg.getValue()));

	}

}
