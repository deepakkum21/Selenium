package com.deepak.stpl.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitInSelenium {
    public static void main(String... strings) {
        // System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\deepak\\Desktop\\Git\\Selenium\\Selenium\\SeleniumDemoPro\\src\\main\\resources\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://www.facebook.com");

        chromeDriver.manage().deleteAllCookies();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        WebElement firstNameElement = chromeDriver.findElement(By.name("firstname"));
        WebElement lastNameElement = chromeDriver.findElement(By.name("lastname"));

        sendKeys(chromeDriver, firstNameElement, 10, "Deepak");
        sendKeys(chromeDriver, lastNameElement, 10, "Kumar");

        WebElement forgotAccount = chromeDriver.findElement(By.linkText("Forgotten account?"));
        clickOn(chromeDriver, forgotAccount, 10);
        chromeDriver.quit();

    }

    // Explicit Wait for send keys
    public static void sendKeys(WebDriver driver, WebElement element, int timeOut, String value) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    // explicit wait for click
    public static void clickOn(WebDriver driver, WebElement element, int timeOut) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}