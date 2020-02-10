package com.maven.seleniumTest;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class Page {
	
	private String pageName;
	private int pageCount;
	
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public void isPageChanged(WebDriver driver, String newUrl) {
		Assert.assertEquals(driver.getCurrentUrl(), newUrl);
	}
}
