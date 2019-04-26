package com.stpl.deepak.gtn.login;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.stpl.deepak.gtn.utlity.FindAction;
import com.stpl.deepak.gtn.utlity.FindPropertyType;
import com.stpl.deepak.gtn.utlity.ReadExcelFile;

public class LoginTest {
	private WebDriver chromeDriver;
	private ReadExcelFile readFile;
	private int noOfrows;
	private String targetUrl;
	private FindAction findAction = new FindAction();
	private FindPropertyType findProType = new FindPropertyType();
	private boolean isPresent;

	@BeforeSuite
	@Parameters("excelPath")
	public void getExcelFile(String excelPath) {
		readFile = new ReadExcelFile(excelPath);
		System.out.println("File read from :" + excelPath);
		noOfrows = readFile.getRowCount(0);
		System.out.println(noOfrows);

	}

	@BeforeTest
	@Parameters({ "driver", "driverpath", "url" })
	public void loadingDriver(String driver, String driverpath, String url) {
		System.out.println(driver + "   " + driverpath);
		System.setProperty(driver, driverpath);
		chromeDriver = new ChromeDriver();
		targetUrl = url;

	}

	@AfterTest
	public void cleanUp() {
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.quit();
	}

	@Test(dataProvider = "getData")
	public void loginTest(String userName, String password) {
		int loginRows = readFile.getRowCount(1);
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.get(targetUrl);

		List<String> contentList = new ArrayList<>();
		contentList.add(userName);
		contentList.add(password);

		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Assert.assertTrue(true);
		System.out.println(userName + password);
		for (int row = 1; row < loginRows; row++) {
			String action = readFile.getData(1, row, 2);
			String propertyType = readFile.getData(1, row, 3);
			String propertyName = readFile.getData(1, row, 4);
			System.out.println(action + " " + propertyType + " " + propertyName);
			WebElement element = findProType.findPropertyType(propertyType, chromeDriver, propertyName);
			System.out.println(element);
			if ("Entertext".equalsIgnoreCase(action)) {
				findAction.applyAction(element, action, contentList.get(row - 1));
			} else {
				findAction.applyAction(findProType.findPropertyType(propertyType, chromeDriver, propertyName), action,
						null);
			}
		}

		// chromeDriver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_login")).clear();
		/*
		 * chromeDriver.findElement(By.id(
		 * "_com_liferay_login_web_portlet_LoginPortlet_login")).sendKeys(userName);
		 * chromeDriver.findElement(By.id(
		 * "_com_liferay_login_web_portlet_LoginPortlet_password")).sendKeys(password);
		 * chromeDriver.findElement(By.className("lfr-btn-label")).click();
		 */

		/*chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement navBarElement = chromeDriver.findElement(By.xpath(
				"//a[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_sidenavToggleId']"));
		clickOn(chromeDriver, navBarElement, 30);*/

		try {
			chromeDriver.findElement(By.xpath("//span[contains(text(),'Welcome')]"));
			isPresent = true;
		} catch (NoSuchElementException exp) {
			System.out.println("Element was Not Present, Sorry Invalid credentials");
			isPresent = false;
		}
		if (isPresent) {
			assertEquals(isPresent, true);
		} else {
			assertEquals(isPresent, false);
		}
		/*Assert.assertTrue(
				chromeDriver.findElement(By.xpath("//span[contains(text(),'Welcome')]")).getText().matches("Welcome"),
				"Invalid Credentials");*/
	}

	@DataProvider
	public String[][] getData() {
		String[][] credentials = new String[noOfrows - 1][2];
		int index;
		for (int row = 1; row < noOfrows; row++) {
			index = row - 1;
			System.out.println(index);
			credentials[index][0] = readFile.getData(0, row, 0);
			credentials[index][1] = readFile.getData(0, row, 1);
			System.out.println(credentials[index][0] + " " + credentials[index][1]);
		}
		return credentials;
	}

	// explicit wait for click
	public static void clickOn(WebDriver driver, WebElement element, int timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("element: " + element);
		element.click();
	}
}
