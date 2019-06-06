package com.listener;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class Reporter implements IReporter{
	Logger logger = Logger.getLogger(Reporter.class);

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		for (ISuite iSuite : suites) {
			
			System.out.println(iSuite.getName());
			
			Map<String, ISuiteResult> results = iSuite.getResults();
			
			for (ISuiteResult rs : results.values()) {
				ITestContext context = rs.getTestContext();
				System.out.println("All Tests are "+context.getAllTestMethods().length);
				System.out.println("Passed Tests are "+context.getPassedTests().size());
				System.out.println("Failed Tests are "+context.getFailedTests().size());
				logger.info("All Tests are "+context.getAllTestMethods().length);
				logger.info("Passed Tests are "+context.getPassedTests().size());
				logger.info("Failed Tests are "+context.getFailedTests().size());
				
			}
			
		}
		
	}

}
