package com.ngocpm;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMenuHDSV {
	
	public WebDriver driver;
	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver","D:\\TaiNguyen\\TaiNguyen\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://caodang.fpt.edu.vn/");
		driver.manage().window().maximize();
	}
	
	@Test(expectedExceptionsMessageRegExp = "Lỗi")
	public void testFacebookLogin()  throws AssertionError, InterruptedException {
		Actions action = new Actions(driver);
		
		WebElement menuhdsv = driver.findElement(By.id("menu-item-53331"));
		WebElement hn = driver.findElement(By.id("menu-item-53374"));
		action.moveToElement(menuhdsv).moveToElement(hn).click().build().perform();
		Thread.sleep(5000);
		String url ="https://caodang.fpt.edu.vn/category/tin-tuc-poly/ha-noi-tin-sinh-vien";
		String actualUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, url);
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
