package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class EditBillinAddressPage extends TestBase{
	
	static public Actions actions;
	static public Logger logger = Logger.getLogger(EditBillinAddressPage.class);
	
	public EditBillinAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='billing_first_name']")
	@CacheLookup
	WebElement objInputFirstName;
	
	@FindBy(how=How.XPATH,using="//input[@id='billing_last_name']")
	@CacheLookup
	WebElement objInputLastName;
	
	@FindBy(how=How.XPATH,using="//input[@id='billing_company']")
	@CacheLookup
	WebElement objInputCompanyName;
	
	@FindBy(how=How.XPATH,using="//input[@id='billing_phone']")
	@CacheLookup
	WebElement objInputPhone;
	
	@FindBy(how=How.XPATH,using="//input[@id='billing_address_1']")
	@CacheLookup
	WebElement objInputBillingAddress;
	
	@FindBy(how=How.XPATH,using="//input[@id='billing_city']")
	@CacheLookup
	WebElement objInputCity;
	
	@FindBy(how=How.XPATH,using="//input[@id='billing_postcode']")
	@CacheLookup
	WebElement objInputPostalCode;
	
	@FindBy(how=How.XPATH,using="//input[@name='save_address']")
	@CacheLookup
	WebElement objInputSaveAddressButton;
	
	static By objDivSelectCountry = By.xpath("//div[@id='s2id_billing_country']/child::*[1]");
	static By objDivState = By.xpath("//div[@id='s2id_billing_state']/child::*[1]");
	
	
	public String getEditBillingAddressPageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public LogoutPage editAddressInfo(String fname,String lname,String cname,String phone,String country,String address,String town,String state,String postalCode)
	{
		objInputFirstName.clear();
		objInputFirstName.sendKeys(fname);
		
		objInputLastName.clear();
		objInputLastName.sendKeys(lname);
		
		objInputCompanyName.clear();
		objInputCompanyName.sendKeys(cname);
		
		objInputPhone.clear();
		objInputPhone.sendKeys(phone);
		
		actions = new Actions(driver);
		actions.click(driver.findElement(objDivSelectCountry)).build().perform();
		actions.sendKeys(country,Keys.DOWN,Keys.ENTER).build().perform();
		
		objInputBillingAddress.clear();
		objInputBillingAddress.sendKeys(address);
		
		objInputCity.clear();
		objInputCity.sendKeys(town);
		
		actions.click(driver.findElement(objDivState)).build().perform();
		actions.sendKeys(state,Keys.ENTER).build().perform();
		
		objInputPostalCode.clear();
		objInputPostalCode.sendKeys(postalCode);
		
		objInputSaveAddressButton.click();
		
		//logger.info("Edit Billing Address Page Verified - Test Passed");
		return new LogoutPage();
		
		
	}
	
	
	
	
	
	

}
