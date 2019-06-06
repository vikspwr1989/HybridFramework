package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class SliderPage extends TestBase{
	
	public SliderPage() {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH,using="//a[text()='My Account']")
	@CacheLookup
	WebElement objLinkMyAccount;
	
	public String getSliderPageTitle()
	{
		return driver.getTitle();
	}
	
	public LoginPage clickMyAccountLink()
	{
		objLinkMyAccount.click();
		return new LoginPage();
	}

}
