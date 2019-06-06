package com.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.SliderPage;
import com.reports.ReportGenerator;
import com.testbase.TestBase;
import com.util.ScreenshotUtility;

public class SliderPageTest extends TestBase{
	
	static Logger logger = Logger.getLogger(SliderPageTest.class);
	static public SliderPage sliderPage;
	static public LoginPage loginPage;
	
	public SliderPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		init();
		logger.info(properties.getProperty("browserName")+" Browser Started");
		sliderPage = new SliderPage();
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
	public void verifySliderPageTitle()
	{
		String sliderPageActualTitle = sliderPage.getSliderPageTitle();
		Assert.assertEquals(sliderPageActualTitle, "Automation Practice Site","Title Not Matched");
		logger.info("Slider Title Test Verified");
		ReportGenerator.stepDetails("PASS", "Get Slider Page Title", "Expected : Slider Title page should verified <br /> Actual : Slider Title page was verified", ScreenshotUtility.takeScreenshot("SliderPageTitle"));
	}
	
	@Test(priority=2)
	public void verifyClickMyAccountLink()
	{
		loginPage = sliderPage.clickMyAccountLink();
		logger.info("My Account Link clicked -  Test Verified");
		ReportGenerator.stepDetails("PASS", "Click My Account Link", "Expected : Should click on My Account Link <br /> Actual : was clicked on My Account Link", ScreenshotUtility.takeScreenshot("MyAccountLink"));
		
	}

}
