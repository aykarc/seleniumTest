package com.maven.seleniumTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AppTest {
	@Test
	public void login() throws InterruptedException {
		HelperFactory helper = new HelperFactory();
		System.setProperty("webdriver.gecko.driver", "/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		Page page = new Page();
		page.setPageName("N11");
		page.setPageCount(0);
		
		HomePage homePage = new HomePage();
		homePage.setSiteName("https://www.n11.com");
		
		
		driver.get(homePage.getSiteName());
		
		// sayfadaki class ismi btnSignIn olan butona tıklattık.
		driver.findElement(By.className("btnSignIn")).click();
		Thread.sleep(2000);

		LoginPage loginPage = new LoginPage();
		loginPage.setPageName("N11 Login");
		loginPage.setUserEmail("aykcan46@gmail.com");
		loginPage.setUserPass("06061993aa");
		
		
		// email ve password alanları doldurulup login butonuna tıklattık.
		driver.findElement(By.id("email")).sendKeys(loginPage.getUserEmail());
		driver.findElement(By.id("password")).sendKeys(loginPage.getUserPass());
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(2000);

		// login işlemi başarılı mı diye kontrol ettik.
		loginPage.checkLogin(driver.findElement(By.className("user")));		

		SearchPage searchPage = new SearchPage();
		searchPage.setSearchName("bilgisayar");
		
		driver.findElement(By.id("searchData")).sendKeys(searchPage.getSearchName());
		driver.findElement(By.className("iconSearch")).click();
		Thread.sleep(2000);

		page.setPageCount(2);
		// 2. sayfaya gittik. 2. sayfaya giden href'in aynı olmasından yakalayıp click yaptık.
		driver.findElement(By.xpath("//a[@href='https://www.n11.com/arama?q=bilgisayar&pg=2']")).click();
		Thread.sleep(2000);

		
		// 2. sayfada mıyız diye kontrol ettik.
		page.isPageChanged(driver, "https://www.n11.com/arama?q=bilgisayar&pg=2");
		
		
		//class ismi adBg olan tüm ürünler arasında random bir ürün seçtik.
		List<WebElement> productElems = driver.findElements(By.className("adBg"));
		int randomProduct = helper.randomNumberGenerateFact(productElems.size());
		Product product = new Product();
		
		//class ismi plink olan tüm ürünler arasında random bir ürün seçtik.
		WebElement productDetail = productElems.get(randomProduct);
		product.setProductName(productDetail.getText());
		product.setProductCount(1);
		//Arama sayfasında rastgele seçtiğimiz ürünün fiyatını aldık.
		String amountSearchItemsList = productDetail.findElement(By.className("newPrice")).getText();
		System.out.println(amountSearchItemsList);
		product.setPrice(amountSearchItemsList);
		
		//Rastgele seçtiğimiz ürünün ekranına gittik.
		productDetail.findElement(By.className("newPrice")).click();
		Thread.sleep(2000);
		
		//Sepete ekleme işlemini gerçekleştirdik.
		driver.findElement(By.className("btnAddBasket")).click();	
		Thread.sleep(2000);
		
		//Sepete gittik.
		driver.findElement(By.xpath("//a[@title='Sepetim']")).click();
		Thread.sleep(2000);
		
		//Ürünün sayfasındaki fiyatı aldık
		BasketPage basket = new BasketPage();
		String basketPrice = driver.findElement(By.className("priceArea")).getText();
		basket.setPrice(basketPrice);
		basket.setProduct(product);
		
		//Ürün sayfasındaki fiyat ile Sepetteki ürün fiyatları karşılaştırıldı
		basket.checkBasketAmount();
		
		//Adet arttırıldı.
		product.plusProductCount();
		driver.findElement(By.className("spinnerUp")).click();
		Thread.sleep(2000);
		
		//Ürün adetinin 2 olup olmadığı kontrolü.
		int count = new Integer(driver.findElement(By.className("quantity")).getAttribute("value"));
		product.checkProductCount(count);
		
		//Ürünün silinmesi kısmı.
		driver.findElement(By.className("removeProd")).click();
		product.productDelete();
		Thread.sleep(3000);
		
		//Sepetin boş kontrolü.
		basket.setEmptyBasketName(driver.findElement(By.className("cartEmptyText")).getText());
		basket.isBasketEmpty();
		basket.basketClear();
	}
}
