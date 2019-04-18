package com.deepak.stpl.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
	
	public static void main(String... strings ) {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		// 1.Find Element By Name
		// driver.findElement(By.name("q")).sendKeys("cricbuzz.com");
		
		// 2.Find Elemnt by Xpath
		// driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("cricbuzz.com");;
		
		// 3.Find Elemnt by id
		// driver.findElement(By.id("Id of the element")).sendKeys("key u want to send");

		// 4. link text
		// driver.findElement(By.linkText("Learn more")).click();

		// 5. Partial link text
		// not recommended to use, use linkText()
		// driver.findElement(By.partialLinkText("Learn mo")).click();

		// 6. CssSelector
		// if id is present the #{id}
		// if class is present then .{class}
		// driver.findElement(By.cssSelector("#id value")).sendKeys("key to be sent");

		// 7. className 
		// Not recommended, it might have been used multiple times
		// driver.findElement(By.className("className")).click();  // or sendKeys();

		// 8. tagName
		
		// to close the browser
		driver.quit();
	}
}
