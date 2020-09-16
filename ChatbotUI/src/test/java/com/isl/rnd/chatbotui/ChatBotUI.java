package com.isl.rnd.chatbotui;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.isl.rnd.utlity.FindAction;
import com.isl.rnd.utlity.FindPropertyType;
import com.isl.rnd.utlity.ReadExcelFile;

public class ChatBotUI {
	private WebDriver chromeDriver;
	private ReadExcelFile readFile;
	private int noOfrows;
	private FindAction findAction = new FindAction();
	private FindPropertyType findProType = new FindPropertyType();
	private int testCaseSheetNo;

	@BeforeSuite
	@Parameters({ "excelPath" })
	public void getExcelFile(String excelPath) {

		readFile = new ReadExcelFile(excelPath);
		System.out.println("File read from :" + excelPath);

	}

	@BeforeClass
	@Parameters({ "driver", "driverpath", "url", "testCaseSheetNo" })
	public void loadingDriver(String driver, String driverpath, String url, int sheetNo) throws InterruptedException {
//		testCaseSheetNo = sheetNo;
//		System.out.println(testCaseSheetNo);
//		noOfrows = readFile.getRowCount(testCaseSheetNo);
//		System.out.println(noOfrows);
//		System.out.println(driver + "   " + driverpath);
//		System.setProperty(driver, driverpath);
//
//		ChromeOptions options = new ChromeOptions();
//
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("download.prompt_for_download", false);
//		options.setExperimentalOption("prefs", prefs);
//		chromeDriver = new ChromeDriver(options);
//		chromeDriver.manage().window().maximize();
//		chromeDriver.manage().deleteAllCookies();
//		chromeDriver.get(url);
//		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(invocationCount = 1)
	@Parameters({ "driver", "driverpath", "url", "testCaseSheetNo" })
	public void testOutlook(String driver, String driverpath, String url, int sheetNo) {
		testCaseSheetNo = sheetNo;
		// System.out.println(testCaseSheetNo);
		noOfrows = readFile.getRowCount(testCaseSheetNo);
//		System.out.println(noOfrows);
//		System.out.println(driver + "   " + driverpath);
		System.setProperty(driver, driverpath);

		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.prompt_for_download", false);
		options.setExperimentalOption("prefs", prefs);
		chromeDriver = new ChromeDriver(options);
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.get(url);
		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions mouseAction = new Actions(chromeDriver);

		for (int row = 1; row < noOfrows; row++) {
			String skipTestCase = readFile.getData(testCaseSheetNo, row, 1);
			if ("No".equalsIgnoreCase(skipTestCase)) {
				String action = readFile.getData(testCaseSheetNo, row, 3);
				String propertyType = readFile.getData(testCaseSheetNo, row, 4);
				String propertyName = readFile.getData(testCaseSheetNo, row, 5);
				System.out.println(action + " " + propertyType + " " + propertyName);
				WebElement element = findProType.findPropertyType(propertyType, chromeDriver, propertyName);
				System.out.println(element);
				if ("Entertext".equalsIgnoreCase(action)) {
					findAction.applyAction(element, action, readFile.getData(testCaseSheetNo, row, 2).replace("'", ""));
				} else if ("Comparetext".equalsIgnoreCase(action)) {
					String readText = readFile.getData(testCaseSheetNo, row, 2);
					System.out.println(
							readText + "      jjjjjjjjjjjjjjjjjjjjjjjj     " + element.getAttribute(propertyName));
				} else

				{
					// System.out.println("row "+ row + " action "+ action );
//					Actions actions = new Actions(chromeDriver);
//					actions.moveToElement(element).click(element).build().perform();
					findAction.applyAction(element, action, null);
					if (readFile.getData(testCaseSheetNo, row, 6) != null) {
						if (readFile.getData(testCaseSheetNo, row, 6).equalsIgnoreCase("yes")) {
							try {
								Thread.sleep(10000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}

				}
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.quit();

	}

	@AfterClass
	public void cleanUp() {
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		chromeDriver.manage().deleteAllCookies();
//		chromeDriver.quit();
	}

}
