package com.regmovies.qa.utils;

public class LogInData {
	
	//encap learn data hiding
	
	private String expectedTitle; 
	private String expectedHeader;
	private String email;
	private String passWord;
	private String errorMsg;
	
	
	public LogInData(String expectedTitle, String expectedHeader, String email, String passWord, String errorMsg) {
		this.expectedTitle = expectedTitle;
		this.expectedHeader = expectedHeader;
		this.email = email;
		this.passWord = passWord;
		this.errorMsg = errorMsg;
	}


	public String getExpectedTitle() {
		return expectedTitle;
	}


	public String getExpectedHeader() {
		return expectedHeader;
	}


	public String getEmail() {
		return email;
	}


	public String getPassWord() {
		return passWord;
	}


	public String getErrorMsg() {
		return errorMsg;
	}
	
	

}
