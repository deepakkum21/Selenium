package com.deepak.stpl.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitInSelenium {
    public static void main(String... strings ) {
        //System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepak\\Desktop\\Git\\Selenium\\Selenium\\SeleniumDemoPro\\src\\main\\resources\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://www.google.com");

        chromeDriver.manage().deleteAllCookies();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        // implicit Wait
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        chromeDriver.quit();
    }
}