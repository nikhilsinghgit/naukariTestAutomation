package com.naukari.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Scenario3Page;

public class Scenario3Test extends TestBase {
	
	Scenario3Page scenario3Page;
	
	public Scenario3Test() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		Initialize();
		scenario3Page = new Scenario3Page();
	}
	
	@Test(priority = 1)
	public void InValidLoginTestAlert() {
		scenario3Page = scenario3Page.login(properties.getProperty("usernameInavlid"),
				properties.getProperty("passworInvalid"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
