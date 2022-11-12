package com.qa.pages;

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
	
	@FindBy(xpath = "//*[@id='root']/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input")
	WebElement textEmailaddress;
	
	@FindBy(xpath = "//*[@id='root']/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input")
	WebElement textPassword;
	
	@FindBy(xpath = "//*[@id='root']/div[4]/div[2]/div/div/div[2]/div/form/div[6]/button")
	WebElement buttonSubmit;
	
	public Scenario3Page() {

		PageFactory.initElements(driver, this);
	}
	
	
	public Scenario3Page login(String usernamn, String password) {
		clickOn(driver, buttonLogin, 5);
		sendKeys(driver, textEmailaddress, 5, usernamn);
		sendKeys(driver, textPassword, 5, password);
		clickOn(driver, buttonSubmit, 5);
		
//		sendKeys(driver, textEmailaddress, 5, usernamn);
//		sendKeys(driver, textPassword, 5, password);
//		clickOn(driver, buttonLogin, 5);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", buttonLogin);

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
