package com.regmovies.qa.utils;

public enum DataMap {
	
	Title("Title"), Header("Header"), Email("Email"), Password("Password"), ErrorMsg("Error-Msg");

	private String value;
	
	private DataMap(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
