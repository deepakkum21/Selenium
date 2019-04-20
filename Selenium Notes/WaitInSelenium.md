# Waits In Selenium?

## Why Do We Need Waits In Selenium?
1. Most of the web applications are developed using Ajax and Javascript. When a page is loaded by the browser the elements which we want to interact with may load at different time intervals.
2. Not only it makes this difficult to identify the element but also if the element is not located it will throw an "ElementNotVisibleException" exception. Using Waits, we can resolve this problem.
3. Let's consider a scenario where we have to use both implicit and explicit waits in our test. Assume that implicit wait time is set to 20 seconds and explicit wait time is set to 10 seconds.
4. Suppose we are trying to find an element which has some "ExpectedConditions "(Explicit Wait), If the element is not located within the time frame defined by the Explicit wait(10 Seconds), It will use the time frame defined by implicit wait(20 seconds) before throwing an "ElementNotVisibleException".

## Selenium Web Driver Waits
1. Implicit Wait
2. Explicit Wait
3. Fluent Waits

## Implicit Wait
1. Selenium Web Driver has borrowed the idea of implicit waits from Watir.
2. The implicit wait will tell to the web driver to wait for certain amount of time before it throws a "No Such Element Exception". The default setting is 0. Once we set the time, web driver will wait for that time before throwing an exception.
3. In the below example we have declared an implicit wait with the time frame of 10 seconds. It means that if the element is not located on the web page within that time frame, it will throw an exception.
4. Syntax:
    `driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);`
5. Implicit wait can be override anytime , anywhere in the code , when changed it will take the new implicit value.
6. it is a global wait.
7. eg:-

            package com.deepak.stpl.selenium;
            import java.util.concurrent.TimeUnit;
            import org.openqa.selenium.By;
            import org.openqa.selenium.WebDriver;
            import org.openqa.selenium.chrome.ChromeDriver;
            import org.testng.annotations.Test;
            public class AppTest {                
                protected WebDriver driver;
                @Test
                public void guru99tutorials() throws InterruptedException 
                {
                System.setProperty ("webdriver.chrome.driver",".\\chromedriver.exe" );
                driver = new ChromeDriver(); 
                driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
                String eTitle = "Demo Guru99 Page";
                String aTitle = "" ;
                // launch Chrome and redirect it to the Base URL
                driver.get("http://demo.guru99.com/test/guru99home/" );
                //Maximizes the browser window
                driver.manage().window().maximize() ;
                //get the actual value of the title
                aTitle = driver.getTitle();
                //compare the actual title with the expected title
                if (aTitle.equals(eTitle))
                {
                System.out.println( "Test Passed") ;
                }
                else {
                System.out.println( "Test Failed" );
                }
                //close browser
                driver.close();
            }
            }


## Explicit Wait
1. The explicit wait is used to tell the Web Driver to wait for certain conditions (Expected Conditions) or the maximum time exceeded before throwing an "ElementNotVisibleException" exception.
2. The explicit wait is an intelligent kind of wait, but it can be applied only for specified elements. Explicit wait gives better options than that of an implicit wait as it will wait for dynamically loaded Ajax elements.
3. Once we declare explicit wait we have to use "ExpectedCondtions" or we can configure how frequently we want to check the condition using Fluent Wait. 
4. These days while implementing we are using Thread.Sleep() generally it is not recommended to use.
5. **Syntax:**                  
    `WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);`

6. The following are the **Expected Conditions that can be used in Explicit Wait**
-    alertIsPresent()
-    elementSelectionStateToBe()
-    elementToBeClickable()
-    elementToBeSelected()
-    frameToBeAvaliableAndSwitchToIt()
-    invisibilityOfTheElementLocated()
-    invisibilityOfElementWithText()
-    presenceOfAllElementsLocatedBy()
-    presenceOfElementLocated()
-    textToBePresentInElement()
-    textToBePresentInElementLocated()
-    textToBePresentInElementValue()
-    titleIs()
-    titleContains()
-    visibilityOf()
-    visibilityOfAllElements()
-    visibilityOfAllElementsLocatedBy()
-    visibilityOfElementLocated()

7. **eg**

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

## Note:
**implicit wait and explicit wait should not be used together.**

## Difference between Implicit Wait Vs Explicit Wait

| **Implicit Wait** | **Explicit Wait** |
| ----------------- | ----------------- |               
| Implicit Wait time is applied to all the elements in the script | Explicit Wait time is applied only to those elements which are intended by us |                         
| In Implicit Wait, we need not specify "ExpectedConditions" on the element to be located | In Explicit Wait, we need to specify "ExpectedConditions" on the element to be located |                
| It is recommended to use when the elements are located with the time frame specified in implicit wait | It is recommended to use when the elements are taking long time to load and also for verifying the property of the element like(visibilityOfElementLocated, elementToBeClickable,elementToBeSelected) |   

## Fluent Wait
1. The fluent wait is used to tell the web driver to wait for a condition, as well as the frequency with which we want to check the condition before throwing an "ElementNotVisibleException" exception.
2. Frequency: Setting up a repeat cycle with the time frame to verify/check the condition at the regular interval of time
3. Let's consider a scenario where an element is loaded at different intervals of time. The element might load within 10 seconds, 20 seconds or even more then that if we declare an explicit wait of 20 seconds. It will wait till the specified time before throwing an exception. In such scenarios, the fluent wait is the ideal wait to use as this will try to find the element at different frequency until it finds it or the final timer runs out.
4. **Syntax**

        Wait wait = new FluentWait(WebDriver reference)
                    .withTimeout(timeout, SECONDS)
                    .pollingEvery(timeout, SECONDS)
                    .ignoring(Exception.class);
