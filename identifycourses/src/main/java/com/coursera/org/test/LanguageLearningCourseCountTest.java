package com.coursera.org.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.coursera.org.base.Base;
import com.coursera.org.functions.LanguageLearningCoursesCount;
import com.coursera.org.utilities.FileOutput;

public class LanguageLearningCourseCountTest extends Base {

	LanguageLearningCoursesCount count = new LanguageLearningCoursesCount();
	FileOutput fo = new FileOutput();

	@Test(priority = 7, groups = "Smoke Test")
	public void testLoadLanguageLearningPage() {
		System.out.println("*****Language Learning Course Count Test Started*****");
		logger = report.createTest("Searching Language Learning course",
				"This test is for loading Language Learning Page");
		try {
			Thread.sleep(2000);
			count.loadLanguageLearningPage();
			implicitWait(10);
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		assertEquals(getPageTitle(), "Top Language Learning Courses - Learn Language Learning Online | Coursera");
	}

	@Test(priority = 8, groups = "Smoke Test")
	public void testLanguageFilterAndPrintingValuesInExcel() {
		logger = report.createTest("Applying Language Filter and printing values in Excel",
				"This test is for applying language filter and adding values in the excel file");
		try {
			count.languageFilter();
			boolean findLastRow = fo.findLastRow(1) > 0;
			assertEquals(findLastRow, true);
			count.closeLanguageFilter();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 8, groups = "Smoke Test")
	public void testLevelFilterAndPrintingValuesInExcel() {
		logger = report.createTest("Applying Level Filter and printing values in Excel",
				"This test is for applying language filter and adding values in the excel file");
		try {
			count.levelFilter();
			boolean findLastRow = fo.findLastRow(2) > 0;
			assertEquals(findLastRow, true);
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n*****Language Learning Course Count Test Passed Successfully*****");
	}

}
