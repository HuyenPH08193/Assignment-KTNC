package com.ngocpm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTittle {
	public WebDriver driver;
	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver","D:\\TaiNguyen\\TaiNguyen\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://caodang.fpt.edu.vn/");
		driver.manage().window().maximize();
		
	}
	@Test(expectedExceptionsMessageRegExp = "Lỗi",priority = 0)
	public void testTittle1() {
		String  tittletest= "FPOLY";
		String titlefb = driver.getTitle();
			Assert.assertEquals(titlefb, tittletest);	
	}
	@Test(expectedExceptionsMessageRegExp = "Lỗi",priority = 1)
	public void testTittle2() {
		String  tittletest= "Cao đẳng FPT Polytechnic xét tuyển cao đẳng năm 2020";
		String titlefb = driver.getTitle();
			Assert.assertEquals(titlefb, tittletest);	
	}
	@Test(expectedExceptionsMessageRegExp = "Lỗi",priority = 2)
	public void testTittle3() {
		String  tittletest= "Trang chủ";
		String titlefb = driver.getTitle();
			Assert.assertEquals(titlefb, tittletest);	
	}
	@AfterTest
	public void closeDriver() {
//		driver.close();
	}
}
