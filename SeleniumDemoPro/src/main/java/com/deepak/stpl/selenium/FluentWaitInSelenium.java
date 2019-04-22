package com.deepak.stpl.selenium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitInSelenium {
    public static void main(String... strings) {
        // System.setProperty("webdriver.chrome.driver",
        // "src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\deepak\\Desktop\\Git\\Selenium\\Selenium\\SeleniumDemoPro\\src\\main\\resources\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://demo.guru99.com/test/guru99home/");

        chromeDriver.manage().deleteAllCookies();
        
        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        String eTitle = "Demo Guru99 Page";
        String aTitle = "";

        aTitle = chromeDriver.getTitle();
        // compare the actual title with the expected title
        if (aTitle.contentEquals(eTitle)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(chromeDriver).withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(
                        "//a[contains(text(),'Home')]"));
            }
        });
        // click on the selenium link
        clickseleniumlink.click();
        // close~ browser
        chromeDriver.close();
    }
}