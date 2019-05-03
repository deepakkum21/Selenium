package com.stpl.deepak.gtn.companymaster;

import static org.testng.Assert.assertEquals;

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

import com.stpl.deepak.gtn.utlity.FindAction;
import com.stpl.deepak.gtn.utlity.FindPropertyType;
import com.stpl.deepak.gtn.utlity.ReadExcelFile;

public class AddCompanyTest {
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
		comapnyAddRows = readFile.getRowCount(testCaseSheetNo);
		for (int row = 1; row < comapnyAddRows; row++) {
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
				} else if ("Combobox".equalsIgnoreCase(action)) {
					System.out.println(element.getText() + "--------------------");
					String textValue = readFile.getData(testCaseSheetNo, row, 2).replace("'", "");
					Actions actions = new Actions(chromeDriver);
					actions.moveToElement(element).clickAndHold(element)
							.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)).sendKeys(textValue).build().perform();
					// element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

					By selectableText = By.xpath("//tr//td//span[text()='" + textValue + "']");

					chromeDriver.findElement(selectableText).click();
				} else if ("date".equalsIgnoreCase(action)) {
					System.out.println(element.getText() + "--------------------");
					element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
					String textValue = readFile.getData(testCaseSheetNo, row, 2).replace("'", "");
					element.sendKeys(textValue);

					/*
					 * By selectableText = By.xpath("//span[contains(text(),'" + textValue + "')]");
					 * 
					 * chromeDriver.findElement(selectableText).click();
					 */
				} else if ("table".equalsIgnoreCase(action)) {
					try {
						
						chromeDriver.findElement(By.xpath("//*[@id='"+propertyName+"']//*[@class=\"v-grid-row v-grid-row-focused v-grid-row-has-data\"]"));
						
					} catch (NoSuchElementException exp) {
						System.out.println("Exception occurred since 0 rows");
						row++;
					}
				} else {
					Thread.sleep(2000);
//					Actions actions = new Actions(chromeDriver);
//					actions.moveToElement(element).click(element).build().perform();
					findAction.applyAction(findProType.findPropertyType(propertyType, chromeDriver, propertyName),
							action, null);					
				}
			}
		}
		Thread.sleep(20000);

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
