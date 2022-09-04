package com.regmovies.qa.commons;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.io.Files;
import com.regmovies.qa.reportings.Loggers;



public class CommonFunctions {

	WebDriver driver;
	CommonWaits waits;
	
	public CommonFunctions(WebDriver driver, CommonWaits waits) {
		this.driver = driver;
		this.waits = waits;
	}
	
	public void inputValues(WebElement element, String value) {
		try {
			element.sendKeys(value);
			Loggers.getLog(value + " : This values has been passed into ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
	}
	
	public void click(WebElement element) {
		try {
			waits.waitUntilClickable(element);
			element.click();
			Loggers.getLog(element + " ---> This element has been clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
	}
	
	public String getText(WebElement element) {
		String valueString = null;
		try {
			valueString = element.getText();
			Loggers.getLog(element + " ---> This element has text : " + valueString);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
		return valueString;
	}
	
	public String getCurrentUrl(WebDriver driver) {
		Loggers.getLog("Current URL is : " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
	
	public String getTitle(WebDriver driver) {
		Loggers.getLog("The Title of the page is : " + driver.getTitle());
		return driver.getTitle();
	}
	
	public boolean buttonEnabled(WebElement element) {
		boolean button = false;
		try {
			button = element.isEnabled();
			Loggers.getLog(element + " ---> This element is enabled : " + button);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
		return button;
	}

	public boolean isDisplayed(WebElement element) {
		boolean logo = false;
		try {
			logo = element.isDisplayed();
			Loggers.getLog(element + " ---> This element is displayed : " + logo);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
		return logo;
	}
	
	
	public void clear(WebElement element) {
		try {
			element.clear();
			Loggers.getLog("Value has been cleared from this element ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
	}
	
	public boolean isPresent(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		if(elements.size() != 0) {
			Loggers.getLog(elements + " --- > This element is present and has match of : " + elements.size());
			return true;
		}else {
			Loggers.getLog(elements + " --- > This element is NOT present and no match found : " + elements.size());
			return false;
		}
	}
	
	public void selectDropdown(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			Loggers.getLog(value + " : This value has been passed into this element ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.getLog(element + " : This element Not Found");
			Assert.fail();
		}
	}
	
	public void failText() {
		Loggers.getLog(getClass().getMethods()[0].getName() + " ---> has failed");
		Assert.fail();
	}
	
	public String getScreenshot(String testName) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMddyyyy_hh.mm.ss");
		String extension = format.format(date);
		File file = new File("screenShots/" + testName + "_" + extension + ".png");
		TakesScreenshot ss = (TakesScreenshot)driver;
		File outPutFile = ss.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(outPutFile, file.getAbsoluteFile());
			Loggers.getLog("Test has been failed \nScreenshot taken here ---> " + file.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.getLog("Error while taking screenshot");
		}
		return file.getAbsolutePath();
	}
}
