package com.deepak.stpl.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class WebDriverBasics {

	public static void main(String[] args) throws InterruptedException {
		// 1. for firefox
		System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
		WebDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.get("http://www.google.com");

		/*System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("http://www.google.com");*/

		firefoxDriver.getCurrentUrl();
		firefoxDriver.getPageSource();
		firefoxDriver.getTitle();
		
		/*chromeDriver.getCurrentUrl();
		chromeDriver.getPageSource();
		chromeDriver.getTitle();*/

		//chromeDriver.quit();
		firefoxDriver.wait(120);
		firefoxDriver.quit();
		
	}

}
