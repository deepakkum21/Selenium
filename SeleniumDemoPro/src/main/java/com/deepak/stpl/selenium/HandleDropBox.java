package com.deepak.stpl.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDropBox {
    public static void main(String... strings) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();

        // to maximize the window
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().deleteAllCookies();

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
                chromeDriver.findElement(By.className("lfr-btn-label")).click();
                System.out.println(chromeDriver.getCurrentUrl());
            }
        }

        clickAfterLogin(chromeDriver);

    }

    private static void clickAfterLogin(WebDriver chromeDriver) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }
        //chromeDriver.findElement(By.linkText("Global Files")).click();
        chromeDriver.findElement(By.xpath("//*[contains(text(), ' Global Files ')]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }
        chromeDriver.findElement(By.linkText("Company Master")).click();
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("companyId")).clear();
        chromeDriver.findElement(By.id("companyId")).sendKeys("*");
        chromeDriver.findElement(By.xpath("//*[contains(text(), 'SEARCH')]")).click();
    }
}