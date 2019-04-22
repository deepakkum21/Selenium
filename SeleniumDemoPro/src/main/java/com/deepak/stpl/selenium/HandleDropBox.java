package com.deepak.stpl.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleDropBox {
    public static void main(String... strings) {
        // System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepak\\Desktop\\Git\\Selenium\\Selenium\\SeleniumDemoPro\\src\\main\\resources\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();

        // to maximize the window
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

        // implicit Wait
        chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // It is dynamically timeout i.e. it waits till the specified time or if element load 
        chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        chromeDriver.get("https://demo2.bpitechnologies.com");

        chromeDriver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_login")).clear();

        if ("".equalsIgnoreCase(
                chromeDriver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_login")).getText())) {
            chromeDriver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_login"))
                    .sendKeys("john.smith@sysbiz.com");

            if ("".equalsIgnoreCase(chromeDriver
                    .findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_password")).getText())) {
                chromeDriver.findElement(By.id("_com_liferay_login_web_portlet_LoginPortlet_password"))
                        .sendKeys("test");
                clickOn(chromeDriver,chromeDriver.findElement(By.className("lfr-btn-label")),40);
                // System.out.println(chromeDriver.getCurrentUrl());
            }
        }

        clickAfterLogin(chromeDriver);

    }

    private static void clickAfterLogin(WebDriver chromeDriver) {
        //chromeDriver.findElement(By.linkText("Global Files")).click();
        clickOn(chromeDriver,chromeDriver.findElement(By.xpath("//*[contains(text(), ' Global Files ')]")),20);
        clickOn(chromeDriver,chromeDriver.findElement(By.xpath("//span[contains(text(),'Company Master')]")),40);
        
        chromeDriver.findElement(By.id("companyId")).clear();
        chromeDriver.findElement(By.id("companyId")).sendKeys("*");
        // clickOn(chromeDriver,chromeDriver.findElement(By.xpath("//*[contains(text(), 'SEARCH')]")),40);
        clickOn(chromeDriver,chromeDriver.findElement(By.id("gtnSearch01")),40);
    }

    // explicit wait for click
    public static void clickOn(WebDriver driver, WebElement element, int timeOut) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("element: "+ element);
        element.click();
    }
}