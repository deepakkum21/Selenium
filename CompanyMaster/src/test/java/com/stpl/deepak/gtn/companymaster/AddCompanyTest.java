package com.stpl.deepak.gtn.companymaster;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.stpl.deepak.gtn.utlity.FindAction;
import com.stpl.deepak.gtn.utlity.FindPropertyType;
import com.stpl.deepak.gtn.utlity.ReadExcelFile;

public class AddCompanyTest {
	private WebDriver chromeDriver;
	private ReadExcelFile readFile;
	private int noOfrows;
	private FindAction findAction = new FindAction();
	private FindPropertyType findProType = new FindPropertyType();
	private int testCaseSheetNo = 2;
	private int loginRows;

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
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.get(url);
		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loginRows = readFile.getRowCount(testCaseSheetNo);
		for (int row = 1; row < loginRows; row++) {
			String action = readFile.getData(testCaseSheetNo, row, 2);
			String propertyType = readFile.getData(testCaseSheetNo, row, 3);
			String propertyName = readFile.getData(testCaseSheetNo, row, 4);
			System.out.println(action + " " + propertyType + " " + propertyName);
			WebElement element = findProType.findPropertyType(propertyType, chromeDriver, propertyName);
			System.out.println(element);
			if ("Entertext".equalsIgnoreCase(action)) {
				findAction.applyAction(element, action, readFile.getData(testCaseSheetNo, row, 1));
			} else {
				findAction.applyAction(findProType.findPropertyType(propertyType, chromeDriver, propertyName), action,
						null);
			}
		}

	}
	
	@Test
	public void addCompany() {
		assertEquals(true, true);
	}

	@AfterTest
	public void cleanUp() {
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.quit();
	}
}