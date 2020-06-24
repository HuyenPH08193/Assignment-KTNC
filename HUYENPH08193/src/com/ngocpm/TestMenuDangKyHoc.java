package com.ngocpm;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMenuDangKyHoc {
	
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
		
		WebElement menuts = driver.findElement(By.id("menu-item-55625"));
		WebElement childmenu = driver.findElement(By.id("menu-item-69992"));
		action.moveToElement(menuts).moveToElement(childmenu).click().build().perform();
		Thread.sleep(5000);
		String url ="https://caodang.fpt.edu.vn/dang-ky-truc-tuyen";
		String actualUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, url);
	}
//	@BeforeMethod
//	public void setUp() {
//		System.setProperty("webdriver.chrome.driver","D:\\TaiNguyen\\TaiNguyen\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("https://caodang.fpt.edu.vn/dang-ky-truc-tuyen");
//		driver.manage().window().maximize();
//		
//	}
//	@Test(description = "nhap", groups = "dk_poly", priority = 3)
//	public void Check1() {
//		try {
//			List<WebElement> list = driver.findElements(By.className("medium"));
//			list.get(0).sendKeys("Ngô Thị Ngọc Huyền");
//
//			WebElement button = driver.findElement(By.className("gform_button button"));
//			button.click();
//			Thread.sleep(4000);
//
//			List<WebElement> listError = driver.findElements(By.className("gfield_description validation_message"));
//			String actual = listError.get(1).getText();
//			System.out.println("Test 2: " + actual);
//			System.out.println(actual);
//			String expected = "";
//			assertEquals(actual, expected);
//
//		} catch (Exception e) {
////				System.out.println(e);
//		}
//
//	}
	
//	@Test(description = "nhap", groups = "dk_poly", priority = 4)
//	public void Check2() {
//		try {
//			List<WebElement> list = driver.findElements(By.className("medium"));
//			list.get(0).sendKeys("Ngô Thị Ngọc Huyền");
//			list.get(1).sendKeys("0435435676");
//			WebElement button = driver.findElement(By.className("gform_button button"));
//			button.click();
//			Thread.sleep(4000);
////
//			List<WebElement> listError = driver.findElements(By.className("gfield_description validation_message"));
//			String actual = listError.get(1).getText();
//			String expected = "";
//			assertEquals(actual, expected);
//
//		} catch (Exception e) {
//				System.out.println(e);
//		}
//
//	}
	@Test(description = "nhap", groups = "dk_poly", priority = 5)
	public void Check3() {
//		https://caodang.fpt.edu.vn/tuyen-sinh-cao-dang-xet-tuyen?utm_source=web&utm_medium=banner_TC&utm_campaign=TS2020#!
//		https://caodang.fpt.edu.vn/dang-ky-truc-tuyen
		try {
			List<WebElement> list = driver.findElements(By.className("medium"));
			list.get(0).sendKeys("Ngô Thị Ngọc Huyền");
			list.get(1).sendKeys("");
			list.get(2).sendKeys("0435435676");
			Select dropdown = new Select(driver.findElement(By.id("input_1_16")));
			dropdown.selectByIndex(3);
//			Select dropdown1 = new Select(driver.findElement(By.id("input_1_17")));
//			dropdown1.selectByIndex(3);
			list.get(3).sendKeys("5656");
			WebElement button = driver.findElement(By.id("gform_submit_button_1"));
			button.click();
			Thread.sleep(4000);

			List<WebElement> listError = driver.findElements(By.className("gfield gfield_error field_sublabel_below field_description_below gfield_visibility_visible"));
			String actual = listError.get(1).getText();
			System.out.println("Test 2: " + actual);
			System.out.println(actual);
			String expected = "";
			assertEquals(actual, expected);

		} catch (Exception e) {
//				System.out.println(e);
		}

	}
//	@AfterMethod
	@AfterTest
	public void closeDriver() {
//		driver.close();
	}
}
