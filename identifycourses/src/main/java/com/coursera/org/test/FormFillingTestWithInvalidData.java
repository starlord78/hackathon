package com.coursera.org.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.coursera.org.base.Base;
import com.coursera.org.functions.FormFillingDataProvider;
import com.coursera.org.functions.FormFillingFunctionality;
import com.coursera.org.utilities.HighlighterAndScreenshotClass;

public class FormFillingTestWithInvalidData extends Base {

	HighlighterAndScreenshotClass hs = new HighlighterAndScreenshotClass();
	FormFillingFunctionality form = new FormFillingFunctionality();

	@Test(priority = 0, groups = "Regression Test")
	public void testLocateFormForRegressionTest() {
		logger = report.createTest("Locating form for Regression Test",
				"This test is locating form for Regression testing");
		returnhome();
		try {
			Thread.sleep(2000);
			form.locateForm();
			implicitWait(10);
			assertEquals(getPageTitle(), "Coursera for Campus | Online Learning Platform for Universities");
			scrollPage();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("Form loaded successfully");
	}

	@Test(priority = 1, groups = "Regression Test", dataProvider = "formData", dataProviderClass = FormFillingDataProvider.class)
	public void testPassingInvalidDataIntoForm(String f_Name, String l_Name, String job_Func, String job_Title,
			String work_Email, String phone_No, String institute_Name, String institute_Type, String primary_Dis,
			String country, String state, String textArea, String ssName) throws IOException, InterruptedException {

		logger = report.createTest("Passing invalid details into the form",
				"This test is for passing invalid details into the form for Regression testing");
		form.fillFirst_name(f_Name);
		Thread.sleep(1000);

		form.fillLast_name(l_Name);
		Thread.sleep(1000);

		form.fillJob_func(job_Func);
		Thread.sleep(1000);

		form.fillJob_title(job_Title);
		Thread.sleep(1000);

		form.fillEmail(work_Email);
		Thread.sleep(1000);

		form.fillPhone_no(phone_No);
		Thread.sleep(1000);

		form.fillInstitute_name(institute_Name);
		Thread.sleep(1000);

		form.fillInstitute_type(institute_Type);
		Thread.sleep(1000);
		form.scrollPageBy(450);

		form.fillPrimary_dis(primary_Dis);
		Thread.sleep(1000);

		form.fillCountry(country);
		Thread.sleep(1000);

		if (country.equalsIgnoreCase("Country")) {

		} else {
			form.fillState(state);
			Thread.sleep(1000);
		}
		form.fillTextArea(textArea);
		Thread.sleep(1000);

		form.clickSubmitButton();
		Thread.sleep(1000);

		try {
			Thread.sleep(1000);
			hs.takeScreenshot(ssName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(ssName + " Completed");
		assertTrue(true);

		refresh();
		scrollPage();

	}

}
