package com.deepak.stpl.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://www.facebook.com");

        chromeDriver.manage().deleteAllCookies();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        
        WebElement day = chromeDriver.findElement(By.id("day"));
        WebElement month = chromeDriver.findElement(By.id("month"));
        WebElement year = chromeDriver.findElement(By.id("year"));
        
        selectvalueFromDropDownWithSelect(day,"10");
        selectvalueFromDropDownWithSelect(month,"May");
        selectvalueFromDropDownWithSelect(year,"2019");
	}
	
	public static void selectvalueFromDropDownWithSelect(WebElement element , String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

}
