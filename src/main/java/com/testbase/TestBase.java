package com.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.util.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static FileInputStream inputStream;
	public static Properties properties;
	static Logger logger = Logger.getLogger(TestBase.class);
	
	public TestBase() {
		
		try 
		{
			inputStream = new FileInputStream(TestUtils.PROPERTIES_FILE_PATH);
			properties = new Properties();
			properties.load(inputStream);
		}
		catch(FileNotFoundException e) 
		{
			logger.info("File Not Found");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			logger.info("IO Issue");
			e.printStackTrace();
		}

	}
	
	public static void init()
	{
		if(properties.getProperty("browserName").equalsIgnoreCase("CHROME"))
		{
			System.setProperty(TestUtils.CHROME_DRIVER_PACKAGE, TestUtils.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			
		}
		else if(properties.getProperty("browserName").equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
			logger.info("Invalid Browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(properties.getProperty("url"));
	}

}
