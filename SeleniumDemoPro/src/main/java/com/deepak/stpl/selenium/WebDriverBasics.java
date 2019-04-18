package com.deepak.stpl.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class WebDriverBasics {

	public static void main(String[] args) {
		// 1. for firefox
		System.setProperty("webdriver.gecko.driver", "E:\\deepak\\selenium-grid\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");

		System.setProperty("webdriver.chrome.driver", "E:\\deepak\\selenium-grid\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("http://www.google.com");

		chromeDriver.getCurrentUrl();
		chromeDriver.getPageSource();
		chromeDriver.getTitle();

		chromeDriver.quit();
		driver.quit();
		
	}

}
