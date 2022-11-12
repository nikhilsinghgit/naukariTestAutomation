package com.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;

public class Scenario2Page extends TestBase {
	
	@FindBy(xpath = "(//input[@class='suggestor-input '])[1]")
	WebElement textSkillDesignation;
	
	@FindBy(xpath = "//input[@id='expereinceDD']")
	WebElement expereinceDD;
	
	@FindBy(xpath = "//*[@id=\"sa-dd-scrollexpereinceDD\"]/div[1]/ul/li[10]/div/span")
	WebElement scrollexpereinceDD;
	
	@FindBy(xpath = "(//input[@class='suggestor-input '])[2]")
	WebElement inputLocation;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[6]/div/div/div[6]")
	WebElement searchButton;
	
	@FindBy(xpath = "(//a[@class='title fw500 ellipsis'])[1]")
	WebElement comapnyTitle;
	
	
	@FindBy(xpath = "//*[@id='root']/div[4]/div[2]/nav/ul/li[3]/a")
	WebElement servicesAnchorDD;
	
	@FindBy(xpath = "//*[@id='root']/div[4]/div[2]/nav/ul/li[3]/div/ul[1]/li[2]/a")
	WebElement resumeTitle;
	
	@FindBy(xpath ="//*[@id='root']/div[4]/div[2]/nav/ul/li[3]/div/ul[1]/li[3]/a")
	WebElement visualResumeTitle;
	
	
	@FindBy(xpath ="//*[@id='root']/div[4]/div[2]/nav/ul/li[3]/div/ul[1]/li[4]/a")
	WebElement resumeCritiqueTitle;
	
	
	
	public Scenario2Page() {

		PageFactory.initElements(driver, this);
	}
	
	
	public Scenario2Page homePage() {
		
		mouseOver(driver);
		
		clickOn(driver, resumeTitle, 5);
			
		Process1(driver, "Resume Writing for Experienced and Mid Level Professionals | Naukri Fastforward");
		
		
		mouseOver(driver);
	
		clickOn(driver, visualResumeTitle, 5);
		
		Process1(driver, "Visual Resume Writing for Experienced Professionals | Naukri Fastforward");
		driver.navigate().refresh();
		
		
		
		mouseOver(driver);
		
		clickOn(driver, resumeCritiqueTitle, 5);
		
		Process1(driver, "Resume Critique / Reviews | Naukri Fastforward");
		
		return new Scenario2Page();
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.click();

	}
	
public  void mouseOver(WebDriver driver){
		
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(servicesAnchorDD).perform();
		
		
	}


public void Process1(WebDriver driver, String assertValue) {
	
	// hold all window handles in array list
			ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
			// switch to new tab
			driver.switchTo().window(newTb.get(1));
			
			
			String pageTitle = driver.getTitle();

			Assert.assertEquals(pageTitle, assertValue);
			
			driver.close();
			
			driver.switchTo().window(newTb.get(0));
}


}
