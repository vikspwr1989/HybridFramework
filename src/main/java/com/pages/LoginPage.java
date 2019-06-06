package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='username']")
	@CacheLookup
	WebElement objInputUsername;
	
	@FindBy(how=How.XPATH,using="//input[@id='password']")
	@CacheLookup
	WebElement objInputPassword;
	
	@FindBy(how=How.XPATH,using="//input[@name='login']")
	@CacheLookup
	WebElement objInputLoginButton;
	
	public DashboardPage loginToAPS()
	{
		objInputUsername.sendKeys(properties.getProperty("username"));
		objInputPassword.sendKeys(properties.getProperty("password"));
		objInputLoginButton.click();
		
		return new DashboardPage();
	}
	
	public String loginPageTitle()
	{
		return driver.getTitle();
	}
	
	

}
