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

public class TestSearch {
	
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
		WebElement search= driver.findElement(By.className("header_search"));
		search.click();
		
		
		Thread.sleep(1000);
		WebElement input = driver.findElement(By.name("s"));
		input.sendKeys("NGOCPMPH08389");
		
		Thread.sleep(1000);
		WebElement submit= driver.findElement(By.className("search_submit"));
		submit.click();
		
		Thread.sleep(5000);
		WebElement sucssec = driver.findElement(By.xpath("//*[text()='Nothing Found']"));
		Assert.assertTrue(sucssec.isDisplayed());
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
