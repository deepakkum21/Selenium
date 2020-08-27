package com.isl.rnd.utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindPropertyType {
	private WebElement element;

	public WebElement findPropertyType(String property, WebDriver webDriver, String propertyName) {
		System.out.println(property + "-------------- " + propertyName );
		if ("id".equalsIgnoreCase(property)) {
			element = webDriver.findElement(By.id(propertyName));
			
		} else if ("className".equalsIgnoreCase(property)) {
			element = webDriver.findElement(By.className(propertyName));
		} else if ("cssSelector".equalsIgnoreCase(property)) {
			element = webDriver.findElement(By.cssSelector(propertyName));
		} else if ("linkText".equalsIgnoreCase(property)) {
			element = webDriver.findElement(By.linkText(propertyName));
		} else if ("name".equalsIgnoreCase(property)) {
			element = webDriver.findElement(By.name(propertyName));
		} else if ("partialLinkText".equalsIgnoreCase(property)) {
			element = webDriver.findElement(By.partialLinkText(propertyName));
		} else if ("xpath".equalsIgnoreCase(property)) {
			element = webDriver.findElement(By.xpath(propertyName));
		} else if ("tagName".equalsIgnoreCase(property)) {
			element = webDriver.findElement(By.tagName(propertyName));
		}
		return this.element;
	}

}
