package com.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.SliderPage;
import com.reports.ReportGenerator;
import com.testbase.TestBase;
import com.util.ScreenshotUtility;

public class LoginPageTest extends TestBase{
	
	static Logger logger = Logger.getLogger(LoginPageTest.class);
	static public SliderPage sliderPage;
	static public LoginPage loginPage;
	static public DashboardPage dashboardPage;

	public LoginPageTest() {
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
	public void verifyLoginPageTitle()
	{
		String loginPageActualTitle = loginPage.loginPageTitle();
		Assert.assertEquals(loginPageActualTitle, "My Account – Automation Practice Site","Login Page Title Not Verified");
		logger.info("Login Page Title Verified");
		ReportGenerator.stepDetails("PASS", "Login Page Title Verification", "Expected : Login Page Title should Verified <br /> Actual : Login Page Title was Verified", ScreenshotUtility.takeScreenshot("LoginPageTitle"));
	}
	
	@Test(priority=2)
	public void verifyLoginPageLogin()
	{
		dashboardPage = loginPage.loginToAPS();
		logger.info("Login to APS is verified - Test Passed");
		ReportGenerator.stepDetails("PASS", "Login to APS", "Expected : should Login to APS <br /> Actual : was login to APS", ScreenshotUtility.takeScreenshot("LoginPage"));
	}
	
}
