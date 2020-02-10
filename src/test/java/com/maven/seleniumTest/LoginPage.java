package com.maven.seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class LoginPage extends Page {
	
	private String userEmail;
	private String userPass;
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	public void checkLogin(WebElement webElement) {
		Assert.assertEquals(webElement.getText(), "aykcan46@gmail.com");
	}
}
