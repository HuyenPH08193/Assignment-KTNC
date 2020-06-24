package PH08193;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.swing.ComboBoxEditor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.support.ui.Select;

public class Testdangkyonline {

	public static WebDriver driver;
	public static String url = "https://caodang.fpt.edu.vn/";
	public static String webdriver = "webdriver.chrome.driver";
	public static String pathDriver = "D:\\TaiNguyen\\TaiNguyen\\chromedriver.exe";
	public static WebElement checkbox;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty(webdriver, pathDriver);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

	}

	@Test(expectedExceptionsMessageRegExp = "Lỗi")
	public void testLogin() throws AssertionError, InterruptedException {
		Actions action = new Actions(driver);

		WebElement menuts = driver.findElement(By.id("menu-item-55625"));
		WebElement childmenu = driver.findElement(By.id("menu-item-69992"));
		action.moveToElement(menuts).moveToElement(childmenu).click().build().perform();
		Thread.sleep(5000);
		String url = "https://caodang.fpt.edu.vn/dang-ky-truc-tuyen";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, url);
	}

	// k nhập gì
	@Test(description = "nhap", groups = "dk_poly", priority = 1)
	public void Check1() {
		try {
			List<WebElement> list = driver.findElements(By.className("medium"));
			list.get(0).sendKeys("Ngô Thị Ngọc Huyền");

			WebElement button = driver.findElement(By.className("gform_button button"));
			button.click();
			Thread.sleep(4000);

			List<WebElement> listError = driver.findElements(By.className("gfield_description validation_message"));
			String actual = listError.get(1).getText();
			System.out.println("Test 2: " + actual);
			System.out.println(actual);
			String expected = "";

			assertEquals(actual, expected);

		} catch (Exception e) {
//				System.out.println(e);
		}

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
