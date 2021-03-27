package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BassClass;
import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;

public class LoginTest extends BassClass{
	
	// url name : https://classic.crmpro.com/index.html?e=1
	
	@Test(priority=1)
	public void loginApplication() throws Exception {
		
		
		logger=report.createTest("Login To CRM");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		logger.pass("Login Done Sucsessfully");
					
	}	
	
	
}








