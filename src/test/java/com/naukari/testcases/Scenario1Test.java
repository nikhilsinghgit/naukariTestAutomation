package com.naukari.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Scenario1Page;

public class Scenario1Test extends TestBase {
	
	Scenario1Page 	scenario1Page;
	
	public Scenario1Test() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		Initialize();
		scenario1Page = new Scenario1Page();
	}
	@Test
	public void InValidLoginTestAlert() throws InterruptedException {
		scenario1Page = scenario1Page.homePage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
	
	
}
