package com.ngocpm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFooterColor {
	public WebDriver driver;
	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver","D:\\TaiNguyen\\TaiNguyen\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://caodang.fpt.edu.vn/");
		driver.manage().window().maximize();
		
	}
	@Test(expectedExceptionsMessageRegExp = "Lỗi",priority = 0)
	public void testFooterColor1() {
		 List<WebElement> elements= driver.findElements(By.className("footer-widgets"));
		String color= elements.get(0).getCssValue("color");
		String testcase="rgba(255, 255, 255, 1)";
		Assert.assertEquals(color, testcase);
	}
	@Test(expectedExceptionsMessageRegExp = "Lỗi",priority = 1)
	public void testFooterColor2() {
		 List<WebElement> elements= driver.findElements(By.className("footer-widgets"));
		String color= elements.get(0).getCssValue("color");
		String testcase="rgba(28, 30, 33, 1)";
		Assert.assertEquals(color, testcase);
	}
	@AfterTest
	public void closeDriver() {
//		driver.close();
	}
}
