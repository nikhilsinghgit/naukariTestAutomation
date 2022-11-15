package com.qa.pages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class Scenario3Page extends TestBase{
	
	@FindBy(xpath = "//label[@class='floating-label' and contains(text(),'Email address')]")
	@CacheLookup
	WebElement labelEmailaddress;
	
	@FindBy(xpath = "//*[@id='login_Layer']")
	WebElement buttonLogin;
	
	@FindBy(xpath = "//input[@type='text' and @placeholder='Enter your active Email ID / Username']")
	WebElement textEmailaddress;
	
	@FindBy(xpath = "//input[@type='password' and @placeholder='Enter your password']")
	WebElement textPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement buttonSubmit;
	
	@FindBy(xpath = "//div[@class='server-err']")
	WebElement serverErorr;
	
	

	
	public Scenario3Page() {

		PageFactory.initElements(driver, this);
	}
	
	
	public Scenario3Page login(String usernamn, String password) throws IOException {
		clickOn(driver, buttonLogin, 5);
		sendKeys(driver, textEmailaddress, 5, usernamn);
		sendKeys(driver, textPassword, 5, password);
		clickOn(driver, buttonSubmit, 5);
		
		WebElement dialog = serverErorr;
		assertTrue(dialog.isDisplayed());  
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));

		return new Scenario3Page();
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.click();

	}

	
	
}
