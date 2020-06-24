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

public class TestFooterbackbroud {
	public WebDriver driver;
	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver","D:\\TaiNguyen\\TaiNguyen\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://caodang.fpt.edu.vn/");
		driver.manage().window().maximize();
		
	}
	@Test(expectedExceptionsMessageRegExp = "Lỗi",priority = 0)
	public void testFooterbackbroud1() {
		 List<WebElement> elements= driver.findElements(By.className("footer-widgets"));
		String color= elements.get(0).getCssValue("background-color");
		String testcase="rgba(255, 255, 255, 1)";
		Assert.assertEquals(color, testcase);
	}
	@Test(expectedExceptionsMessageRegExp = "Lỗi",priority = 1)
	public void testFooterbackbroud2() {
		 List<WebElement> elements= driver.findElements(By.className("footer-widgets"));
		String color= elements.get(0).getCssValue("background-color");
		String testcase="rgba(25, 32, 65, 1)";
		Assert.assertEquals(color, testcase);
	}
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
}
