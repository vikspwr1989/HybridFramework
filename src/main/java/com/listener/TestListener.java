package com.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.reports.ReportGenerator;


public class TestListener implements ITestListener{
	
	public static int scenarioCount;
	public static int stepCount;
	public static Logger logger = Logger.getLogger(TestListener.class);

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		scenarioCount++;
		ReportGenerator.startTestCase("Scenario "+scenarioCount+" : "+context.getName(), "");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("========================= END OF SCENARIO "+scenarioCount+" =========================");
		logger.info("========================= END OF SCENARIO "+scenarioCount+" =========================");
		ReportGenerator.endTestCase();
		
	}

}
