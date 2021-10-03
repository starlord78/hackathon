package com.coursera.org.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateReport implements ITestListener {

	public static ExtentReports report = extentReport("Extent_Report");
	public static ExtentTest logger;

	public static ExtentReports extentReport(String reportName) {

		FileInput fi = new FileInput();
		// Initializing and returning ExtentReports function
		ExtentReports report = null;
		if (report == null) {
			ExtentHtmlReporter htmlReporter;
			try {
				htmlReporter = new ExtentHtmlReporter(fi.getData("report_path") + reportName + ".html");

				htmlReporter.config().setDocumentTitle("Hackathon Project - Testing Coursera page");
				htmlReporter.config().setReportName("Functional Test Automation Report");
				htmlReporter.config().setTheme(Theme.DARK);

				report = new ExtentReports();
				report.attachReporter(htmlReporter);

				report.setSystemInfo("Operating System", "Windows");
				report.setSystemInfo("Browser", "Chrome");
				report.setSystemInfo("Website", "Coursera");

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return report;

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.assignCategory(result.getMethod().getGroups());
		logger.log(Status.PASS, result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.assignCategory(result.getMethod().getGroups());
		logger.log(Status.FAIL, result.getName());

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}