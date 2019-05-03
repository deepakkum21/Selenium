package com.stpl.deepak.gtn.utlity;

import org.openqa.selenium.WebElement;

public class FindAction {

	public void applyAction(WebElement element, String action, String content) {
		System.out.println(action);
		if ("Entertext".equalsIgnoreCase(action)) {
			element.sendKeys(content);
		} else if ("Click".equalsIgnoreCase(action)) {
			
			/*JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			jse2.executeScript("arguments[0].scrollIntoView()", element);*/
			element.click();
		} else if ("clear".equalsIgnoreCase(action)) {
			element.clear();
		}
	}

}
