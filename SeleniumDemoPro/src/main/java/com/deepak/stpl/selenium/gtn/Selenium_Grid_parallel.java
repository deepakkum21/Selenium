package com.deepak.stpl.selenium.gtn;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Selenium_Grid_parallel 
{
	WebDriver driver1;
	Platform WIN10;
	String nodeURL;
	
	@Parameters({"portNO","appURL"})
	@BeforeMethod()
	public void setUp(String portNO, String appURL) throws InterruptedException, NullPointerException, MalformedURLException
	{			
		if(portNO.equalsIgnoreCase("4545"))
		{
			nodeURL = "http://192.168.0.105:4545/wd/hub";
			System.out.println("Firefox Browser Test Environment created");
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			
			driver1 = new RemoteWebDriver(new URL(nodeURL),cap);			
			driver1.manage().window().maximize();
			driver1.navigate().to(appURL);
			driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else 
		if(portNO.equalsIgnoreCase("4546"))
		{
			nodeURL = "http://192.168.0.105:4546/wd/hub";
			System.out.println("Chrome Browser Test Environment created");
			DesiredCapabilities cap1 = DesiredCapabilities.chrome();			
			cap1.setBrowserName("chrome");
			cap1.setPlatform(Platform.WINDOWS);
			
			driver1 = new RemoteWebDriver(new URL(nodeURL),cap1);			
			driver1.manage().window().maximize();
			driver1.navigate().to(appURL);
			driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else
		if(portNO.equalsIgnoreCase("4547"))
		{
			nodeURL = "http://192.168.0.105:4547/wd/hub";
			System.out.println("Internet Browser Test Environment created");
			DesiredCapabilities cap2 = DesiredCapabilities.internetExplorer();
			cap2.setBrowserName("internet explorer");
			cap2.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			cap2.setPlatform(Platform.WINDOWS);
			
			driver1 = new RemoteWebDriver(new URL(nodeURL),cap2);			
			driver1.manage().window().maximize();
			driver1.navigate().to(appURL);	
			driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else	
        System.err.println("Provide correct port no");
	}
	
	@Test(dataProvider="Authentication")
	public void facebookLogin(String username, String password) throws InterruptedException
	{
		System.out.println("Trying with :"+username);
		System.out.println(driver1.getTitle());
		driver1.findElement(By.cssSelector("input[type='email']")).sendKeys(username);
		driver1.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		driver1.findElement(By.cssSelector("input[value='Log In']")).click();
		
//		String c = driver1.findElement(By.cssSelector("div[class='_4rbf _53ij']")).getText();
//		System.out.println(c);
	}

	@DataProvider(name="Authentication")
	public Object[][] credentials()
	{
		Object[][] obj = new Object[3][2];
		obj[0][0]="Admin";
		obj[0][1]="Admin";
		
		obj[1][0]="Tester";
		obj[1][1]="Tester";
		
		obj[2][0]="Developer";
		obj[2][1]="developer";
		
		return obj;	
	}
	
	@AfterMethod()
	public void tearDown()
	{
			driver1.quit();
			System.out.println("Closing the Browser");
			System.out.println("**************************************************************");
	}
}