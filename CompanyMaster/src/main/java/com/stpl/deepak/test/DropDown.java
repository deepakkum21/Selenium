package com.stpl.deepak.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://www.facebook.com");

        chromeDriver.manage().deleteAllCookies();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        
        WebElement day = chromeDriver.findElement(By.id("day"));
        WebElement month = chromeDriver.findElement(By.id("month"));
        WebElement year = chromeDriver.findElement(By.id("year"));
        
        // use select by selectByVisibleText instead of selectByIndex as index can be changed if some values are added in between
//        selectvalueFromDropDownWithSelectByValue(day,"10");
//        selectvalueFromDropDownWithSelectByValue(month,"May");
//        selectvalueFromDropDownWithSelectByValue(year,"2019");
        
        // without using select class
        List<WebElement> monthList = chromeDriver.findElements(By.xpath("//select[@id='month']//option"));
        for(int i = 0 ; i<monthList.size();i++) {
        	System.out.println(monthList.get(i).getText());
        	if(monthList.get(i).getText().equals("May")) {
        		monthList.get(i).click();
				break;
			}
        }
        	
	}
	
	public static void selectvalueFromDropDownWithSelectByValue(WebElement element , String value) {
		Select select = new Select(element);
		// to see wheather the dropdown supports multiselect
		System.out.println(select.isMultiple());
		// gives all the options present in the slect
		List<WebElement> daysList = select.getOptions();
		// another way of selecting the value using getOptions()
		for(int i=0; i<daysList.size();i++) {
			String dayValue = daysList.get(i).getText();
			if(dayValue.equals(value)) {
				daysList.get(i).click();
				break;
			}
		}
		
		// way of selecting a value from the dropdown
		select.selectByVisibleText(value);
	}

}


