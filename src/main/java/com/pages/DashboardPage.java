package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class DashboardPage extends TestBase{
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'shipping')]")
	@CacheLookup
	WebElement objLinkShippingBilling;
	
	@FindBy(how=How.XPATH,using="(//a[text()='Edit'])[last()-1]")
	@CacheLookup
	WebElement objLinkEditBillingAddress;
	
	public String getDashboardCurrentURL()
	{
		return driver.getCurrentUrl();
	}
	
	public EditBillinAddressPage clickOnEditAddressLink()
	{
		objLinkShippingBilling.click();
		objLinkEditBillingAddress.click();
		return new EditBillinAddressPage();
	}
	
	

}
