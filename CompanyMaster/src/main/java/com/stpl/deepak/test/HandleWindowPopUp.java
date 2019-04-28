package com.stpl.deepak.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {
	
	public static void main(String... arg) throws InterruptedException {
		
		// 1. Alert popup---- javascript pop up -- (Alert API -accept , dismiss)
		// 2. File upload popup ---- Browse Button (When type == File, sendKeys(path of the file ))
		// 3. BrowserWindow popup -- Advertismentpop up (WindowHandler Api---- getWindowHandles())
		
		
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://www.popuptest.com/goodpopups.html");

        chromeDriver.manage().deleteAllCookies();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        chromeDriver.findElement(By.xpath("//a[contains(text(),'Good PopUp #4')]")).click();
        
        Thread.sleep(2000);
        
        Set<String> handler = chromeDriver.getWindowHandles();
        Iterator<String> it= handler.iterator();
        
        String parentWindowId = it.next();
        System.out.println("parentWindowId: "+parentWindowId);
        String childWindowId = it.next();
        System.out.println("childWindowId: "+childWindowId);
        chromeDriver.switchTo().window(childWindowId);
        System.out.println("child window popo up: "+chromeDriver.getTitle());
        chromeDriver.close();
        chromeDriver.switchTo().window(parentWindowId);
        System.out.println("parent window popo up: "+chromeDriver.getTitle());
        
	}

}
