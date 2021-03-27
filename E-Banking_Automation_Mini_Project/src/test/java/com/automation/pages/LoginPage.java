package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver drive;
	public LoginPage(WebDriver ldriver) {
		this.drive=ldriver;	
	}
	
	@FindBy(name="username") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input") WebElement loginButton;
	
	public void loginToCRM(String usernameApplication, String passwordforApplcation) {
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordforApplcation);
		loginButton.click();
	}
		
		
		
	}

