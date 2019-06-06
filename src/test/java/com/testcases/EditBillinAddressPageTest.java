package com.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.EditBillinAddressPage;
import com.pages.LoginPage;
import com.pages.LogoutPage;
import com.pages.SliderPage;
import com.reports.ReportGenerator;
import com.testbase.TestBase;
import com.util.FetchExcelData;
import com.util.ScreenshotUtility;

public class EditBillinAddressPageTest extends TestBase{
	
	static Logger logger = Logger.getLogger(LoginPageTest.class);
	static public SliderPage sliderPage;
	static public LoginPage loginPage;
	static public DashboardPage dashboardPage;
	static public EditBillinAddressPage addressPage;
	static public LogoutPage logoutPage;
	
	public EditBillinAddressPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		init();
		logger.info(properties.getProperty("browserName")+" Browser Started");
		sliderPage = new SliderPage();
		sliderPage.clickMyAccountLink();
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		dashboardPage = loginPage.loginToAPS();
		addressPage = new EditBillinAddressPage();
		addressPage = dashboardPage.clickOnEditAddressLink();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.close();
			logger.info(properties.getProperty("browserName")+" Browser closed");
		}
	}
	
	@Test(priority=1)
	public void verifygetEditBillingAddressPageURL()
	{
		String actualEditBillingAddressPageURL = driver.getCurrentUrl();
		Assert.assertEquals(actualEditBillingAddressPageURL, "http://practice.automationtesting.in/my-account/edit-address/billing/");
		logger.info("Edit Billing Address Page URL Verified - Test Passed");
		ReportGenerator.stepDetails("PASS", "Get Edit Billing Address Page URL", "Expected : should verified Edit Billing Address Page URL <br /> Actual : was verified Edit Billing Address Page URL", ScreenshotUtility.takeScreenshot("EditAddresspageURL"));
	}
	
	@DataProvider
	public Object[][] getData()
	{
	    
		return FetchExcelData.getData("Sheet2");
	}
	
	
	@Test(priority=2,dataProvider="getData")
	public void verifyeditAddressInfo(String fname,String lname,String cname,String phone,String country,String address,String town,String state,String postalCode)
	{
		logoutPage = addressPage.editAddressInfo(fname, lname, cname, phone, country, address, town, state, postalCode);
		logger.info("Edit Address Information Page Verified - Test Passed");
		ReportGenerator.stepDetails("PASS", "Update Address Info", "Expected : Required info should updated <br /> Actual : Required info was updated", ScreenshotUtility.takeScreenshot("UpdateInfo"));
		
		
	}
	

}
