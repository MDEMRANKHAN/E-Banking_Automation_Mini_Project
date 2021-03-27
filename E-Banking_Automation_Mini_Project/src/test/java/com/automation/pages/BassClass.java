package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BassClass {
	
	 public WebDriver driver;
	 public ExcelDataProvider excel;
	 public ConfigDataProvider config;
	 public ExtentReports report;
	 public ExtentTest logger;
	 
	 @BeforeSuite
	 public void setupSuite() throws Exception {
		 
	  Reporter.log("Setting Up Reports and Test is getting ready", true);
	  excel = new ExcelDataProvider();
	  config = new ConfigDataProvider();
	  
	  ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM+"+Helper.getCurrentDateTime()+".html"));
	  report=new ExtentReports();
	  report.attachReporter(extent);
	  Reporter.log("Settings Done->Test Can be Started", true);
	 
	 }
	
	@BeforeClass
	public void setUp() {
		 Reporter.log("Trying to start Browser and getting Application Ready", true);
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
		Reporter.log("Browser and Application is up and running", true);
	}
	@AfterClass
	public void tearDown() {
	BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		
		Reporter.log("Test is About to end", true);
		if(result.getStatus()==ITestResult.FAILURE) {
		logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
			
		report.flush();
		Reporter.log("Test Completed>>>Reports Generated", true);
	}

}
