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

public class TestFormDKTT {
	
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
		Thread.sleep(4000);
		WebElement search= driver.findElement(By.className("button-dangkytuvan"));
		search.click();
//		
		Thread.sleep(4000);
		WebElement input1= driver.findElement(By.name("input_1"));
		input1.sendKeys("NGOCPMPH08389");
		WebElement sucssec = driver.findElement(By.xpath("//*[text()='Đăng kí Ngành Fpoly']"));
		Assert.assertTrue(sucssec.isDisplayed());
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void closeDriver() {
//		driver.close();
	}
}
