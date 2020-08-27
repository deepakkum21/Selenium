package com.isl.rnd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.isl.rnd.utlity.FindAction;
import com.isl.rnd.utlity.FindPropertyType;
import com.isl.rnd.utlity.ReadExcelFile;

public class ChatBotUITest {
	private WebDriver chromeDriver;
	private ReadExcelFile readFile;
	private int noOfrows;
	private FindAction findAction = new FindAction();
	private FindPropertyType findProType = new FindPropertyType();
	private int testCaseSheetNo ;
	private int comapnyAddRows;
	
	
	@BeforeSuite
	@Parameters({"excelPath" })
	public void getExcelFile(String excelPath) {
		
		readFile = new ReadExcelFile(excelPath);
		System.out.println("File read from :" + excelPath);
		
	}
	
	@BeforeTest
	@Parameters({ "driver", "driverpath", "url", "testCaseSheetNo" })
	public void loadingDriver(String driver, String driverpath, String url, int sheetNo) throws InterruptedException {
		testCaseSheetNo = sheetNo;
		System.out.println(testCaseSheetNo);
		noOfrows = readFile.getRowCount(testCaseSheetNo);
		System.out.println(noOfrows);
		System.out.println(driver + "   " + driverpath);
		System.setProperty(driver, driverpath);
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.get(url);
		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testOne() {
		
		
	}

	@AfterTest
	public void cleanUp() {
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.quit();
	}

}
