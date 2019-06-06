package com.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.EditBillinAddressPage;
import com.pages.LoginPage;
import com.pages.SliderPage;
import com.reports.ReportGenerator;
import com.testbase.TestBase;
import com.util.ScreenshotUtility;

public class DashboardPageTest extends TestBase{
	
	static Logger logger = Logger.getLogger(LoginPageTest.class);
	static public SliderPage sliderPage;
	static public LoginPage loginPage;
	static public DashboardPage dashboardPage;
	static public EditBillinAddressPage addressPage;
	
	public DashboardPageTest() {
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
	public void verifygetDashboardCurrentURL()
	{
		String actualURL = dashboardPage.getDashboardCurrentURL();
		Assert.assertEquals(actualURL, "http://practice.automationtesting.in/my-account/");
		logger.info("Dashboard URL verified - Test Passed");
		ReportGenerator.stepDetails("PASS", "Get Dashboard URL", "Expected : http://practice.automationtesting.in/my-account/ <br /> Actual : "+actualURL+"", ScreenshotUtility.takeScreenshot("dashboardURL"));
	}
	
	@Test(priority=2)
	public void verifyclickOnEditAddressLink()
	{
		addressPage = dashboardPage.clickOnEditAddressLink();
		logger.info("Clicked on Edit Address Link - Test Verified");
		ReportGenerator.stepDetails("PASS", "Click Edit Address Link", "Expected : should clicked on edit Address link <br /> Actual : was clicked on edit Address Link", ScreenshotUtility.takeScreenshot("EditAddressLink"));
	}
	
	

}
