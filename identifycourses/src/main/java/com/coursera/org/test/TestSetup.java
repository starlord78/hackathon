package com.coursera.org.test;

import java.io.IOException;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;

import com.coursera.org.base.Base;
 
public class TestSetup extends Base {

	@BeforeSuite(groups = { "Smoke Test", "Regression Test" })
	// This method is used to invoking driver
	public void initialiseSetUp() throws IOException {
		createDriver();
		pageLoadOut(10000);
		implicitWait(10000);

	}

	@AfterSuite(groups = { "Smoke Test", "Regression Test" })
	public void tearDown() {
		report.flush();
		driver.quit();
	}

	@BeforeGroups(groups = "Smoke Test")
	public void beforeGroupStatementSmoke() {
		System.out.println("\n*****Smoke Test started *****");
	}

	@BeforeGroups(groups = "Regression Test")
	public void beforeGroupStatementRegression() {
		System.out.println("\n*****Regression Test started *****\n");
	}

	@AfterGroups(groups = "Regression Test")
	public void resultStatementsRegression() {
		System.out.println("\n***** Regression Test Completed *****");
	}

	@AfterGroups(groups = "Smoke Test")
	public void resultStatementsSmoke() {
		System.out.println("***** Smoke Test Completed *****");
	}

}
