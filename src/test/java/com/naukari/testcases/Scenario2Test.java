package com.naukari.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Scenario2Page;

public class Scenario2Test extends TestBase{
	
	Scenario2Page scenario2Page;
	
	public Scenario2Test() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		Initialize();
		scenario2Page = new Scenario2Page();
	}
	
	
	@Test
	public void InValidLoginTestAlert() throws InterruptedException {
		scenario2Page = scenario2Page.homePage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}


}
