package com.listener;



import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.reports.ReportGenerator;


public class SuitListener implements ISuiteListener{
	
	
	public static Logger logger = Logger.getLogger(SuitListener.class);

	public void onStart(ISuite suite) {
		ReportGenerator.startTestSuite("src/test/resources/Reports/SaveButton.html", "Vikas Pawar");
	//	scenarioCount++;
		//System.out.println("Suite Name :"+scenario.getSourceTagNames());
		System.out.println("Suite Name : "+suite.getName());
		logger.info("Suite Name : "+suite.getName());
		//System.out.println("Scenario "+scenarioCount+" :"+scenario.getName());
		//logger.info("Scenario "+scenarioCount+" :"+scenario.getName());
		
		
	}

	public void onFinish(ISuite suite) {
		
		ReportGenerator.entTestSuite();
		
	}

}
