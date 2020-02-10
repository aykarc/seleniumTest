package com.maven.seleniumTest;

import junit.framework.Assert;

public class BasketPage extends Page {
	private Product product;
	private String price;
	private String emptyBasketName;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void checkBasketAmount() {
		Assert.assertEquals(product.getPrice(), price);
	}
	public String getEmptyBasketName() {
		return emptyBasketName;
	}
	public void setEmptyBasketName(String emptyBasketName) {
		this.emptyBasketName = emptyBasketName;
	}
	public void isBasketEmpty() {
		Assert.assertNotNull(emptyBasketName);
	}
	public void basketClear() {
		product.productDelete();
		price = "0";
		emptyBasketName = "";
	}
}
