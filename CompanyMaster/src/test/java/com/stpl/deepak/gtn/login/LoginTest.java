package com.stpl.deepak.gtn.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.stpl.deepak.gtn.utlity.ReadExcelFile;

public class LoginTest {
	private WebDriver chromeDriver;
	private ReadExcelFile readFile;
	private int noOfrows;
	private String targetUrl;

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
		//chromeDriver.quit();
	}

	@Test(dataProvider = "getData")
	public void loginTest(String userName, String password) {
		//DesiredCapabilities acceptSSLCertificate = DesiredCapabilities.chrome();

	      //Setting capability to accept SSL certificates
	      //acceptSSLCertificate.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		chromeDriver.manage().window().maximize();
		chromeDriver.navigate().to(targetUrl);
		chromeDriver.manage().deleteAllCookies();
		System.out.println(chromeDriver.getCurrentUrl());
		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Assert.assertTrue(true);
		System.out.println(userName + password);
		// chromeDriver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_login")).clear();
		chromeDriver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_login")).sendKeys(userName);
		chromeDriver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_password")).sendKeys(password);
		chromeDriver.findElement(By.className("lfr-btn-label")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*WebElement welcomeElement = chromeDriver.findElement(By.xpath(
				"//a[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_sidenavToggleId']"));
		clickOn(chromeDriver, welcomeElement, 30);
		System.out.println(welcomeElement.toString());*/
		/*Assert.assertTrue(chromeDriver.findElement(By.xpath(
				"//a[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_sidenavToggleId']"))
				.toString().matches(""), "Invalid Credentials");*/
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
			System.out.println(credentials[index][0] + credentials[index][1]);
		}
		return credentials;
	}

    // explicit wait for click
    public static void clickOn(WebDriver driver, WebElement element, int timeOut) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("element: "+ element);
        element.click();
    }
}
