package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import freemarker.template.SimpleDate;

public class Helper {
	
	// handle - screenshots, alerts, frames, windows, sync issues, JavaScript executor
	
	public static String captureScreenshot(WebDriver driver) {
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath =System.getProperty("user.dir")+"/Screenshots/FreeCRM"+getCurrentDateTime()+".png";
		
		try {
			FileHandler.copy(src, new File(screenshotPath));
			
			System.out.println("ScreenShot Captured");
		} catch (Exception e) {
			System.out.println("Enable to capture Screenshot >>"+e.getMessage());	
	}
		return screenshotPath;
	}
		
	
	public static String getCurrentDateTime() {
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date CurrentDate= new Date();
		return customformat.format(CurrentDate);
	}
	
	

}
