package com.maven.seleniumTest;

import java.math.BigDecimal;

import junit.framework.Assert;

public class Product {
	private String productName;
	private int productCount;
	private String price;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void plusProductCount() {
		productCount++;
	}
	public void checkProductCount(int count) {
		Assert.assertEquals(count, this.productCount);
	}
	public void productDelete() {
		productCount = 0;
		productName = "";
		price = "0";
	}
}
