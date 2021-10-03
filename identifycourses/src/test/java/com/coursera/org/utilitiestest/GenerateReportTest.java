package com.coursera.org.utilitiestest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.coursera.org.base.Base;

public class GenerateReportTest extends Base {

	@Test
	public void generateHTMLReport1() {
		logger = report.createTest("Sample Test 1");
		logger.log(Status.PASS, "Test1");
		logger.log(Status.PASS, "Test2");
		logger.log(Status.FAIL, "Test3");
		logger.log(Status.FAIL, "Test4");
		logger.log(Status.INFO, "Test5");
		logger.log(Status.INFO, "Test6");
	}

	@Test
	public void generateHTMLReport2() {
		logger = report.createTest("Sample Test 2");
		logger.log(Status.PASS, "Test1");
		logger.log(Status.PASS, "Test2");
		logger.log(Status.FAIL, "Test3");
		logger.log(Status.FAIL, "Test4");
		logger.log(Status.INFO, "Test5");
		logger.log(Status.INFO, "Test6");
		report.flush();

	}

}
