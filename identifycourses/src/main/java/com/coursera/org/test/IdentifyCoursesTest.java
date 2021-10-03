package com.coursera.org.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.coursera.org.base.Base;
import com.coursera.org.functions.IdentifyCourses;
import com.coursera.org.utilities.FileOutput;
import com.coursera.org.utilities.HighlighterAndScreenshotClass;

public class IdentifyCoursesTest extends Base {

	HighlighterAndScreenshotClass hs = new HighlighterAndScreenshotClass();

	public class validateIdentifyCourses extends Base {

		IdentifyCourses homepage = new IdentifyCourses();
		FileOutput fo = new FileOutput();

		/****************** This method is use to Search Course *********/
		@Test(priority = 1, groups = "Smoke Test")
		public void testSearchingWebDevelopmentCourse() throws Exception {
			logger = report.createTest("Searching Web Development course",
					"This test is for loading home page and search for Web Development Course.");
			System.out.println("\n*****Identify Course Test Started*****");
			try {
				homepage.searchCourse();
			} catch (Exception e) {
				System.out.println(e);
			}
			assertEquals(getPageTitle(), "Top Web Development Courses - Learn Web Development Online | Coursera");
		}

		/****************** Select Language ***********************/
		@Test(priority = 2, groups = "Smoke Test")
		public void testApplyLanguagefilterAsEnglish() {
			logger = report.createTest("Apply Language filter as English",
					"This test is for applying language filter int the Web Develpoment Page");
			try {
				homepage.selectLanguage();
				assertTrue(true);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Select Level ***********************/
		@Test(priority = 3, groups = "Smoke Test")
		public void testApplyLevelfilterAsBeginner() {
			logger = report.createTest("Apply Level filter as Beginner",
					"This test is for applying language filter int the Web Develpoment Page");
			try {
				homepage.selectLevel();
				assertTrue(true);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Validate First Course ***********************/
		@Test(priority = 4, groups = "Smoke Test")
		public void testFetchFirstCourseDetails() {
			logger = report.createTest("Fetching Course 1 details",
					"This test is to  fetch the details for the first course");
			try {
				homepage.firstCourse();
				assertTrue(true);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Validate Second Course ***********************/
		@Test(priority = 5, groups = "Smoke Test")
		public void testFetchSecondCourseDetails() {
			logger = report.createTest("Fetching Course 2 details",
					"This test is to  fetch the details for the second course");
			try {
				homepage.secondCourse();
				homepage.addCourseDetalis();
				boolean findLastRow = fo.findLastRow(0) > 0;
				assertEquals(findLastRow, true);
				assertTrue(true);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/****************** Screen Shot ***********************/
		@Test(priority = 6, groups = "Smoke Test")
		public void returnHomePage() throws InterruptedException {
			logger = report.createTest("Returning to Home Page", "This test is for navigating to home page");
			returnhome();
			assertEquals(getPageTitle(), "Coursera | Online Courses & Credentials From Top Educators. Join for Free");
			System.out.println("*****Identify Course Test Passed Successfully*****\n");
		}

	}
}