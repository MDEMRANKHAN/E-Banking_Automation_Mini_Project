package com.automation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BrowserFactory {
	static WebDriver driver;
	

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		
	
		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); 
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
		}
		
	

	
	public static void quitBrowser(WebDriver driver) {
		
		//driver.quit();
	}
}
