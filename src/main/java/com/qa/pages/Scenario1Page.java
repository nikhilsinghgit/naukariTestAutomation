package com.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class Scenario1Page extends TestBase  {
	
	@FindBy(xpath = "//label[@class='floating-label' and contains(text(),'Email address')]")
	@CacheLookup
	WebElement labelEmailaddress;

	@FindBy(xpath = "//label[@class='floating-label' and contains(text(),'Password')]")
	WebElement lablePassword;

	@FindBy(xpath = "//div[@class='col-lg-12']/h3")
	WebElement LoginPaneTitle;
	
	@FindBy(xpath = "//input[@type='text' and @placeholder='Enter skills / designations / companies']")	
	WebElement textSkillDesignation;
	
	@FindBy(xpath = "//input[@type='text' and @placeholder='Enter location']")
	WebElement inputLocation;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement textPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement buttonLogin;
	
	@FindBy(xpath = "//input[@id='expereinceDD']")
	WebElement expereinceDD;
	
	@FindBy(xpath = "//div[@id='sa-dd-scrollexpereinceDD']//li[@value='#9']")
	WebElement scrollexpereinceDD;
	
	
	@FindBy(xpath = "//div[@class='qsbSubmit']")
	WebElement searchButton;
	
	
	@FindBy(xpath = "(//a[@class='title fw500 ellipsis'])[1]")
	WebElement comapnyTitle;
	

	@FindBy(xpath = "(//a[@class='title fw500 ellipsis'])[1]")
	WebElement comapnyLink;

	@FindBy(xpath = "//*[@id='root']/div[4]/div/section[2]/div[2]/article[2]/div[1]/div[1]/a")
	WebElement comapnyLink2;
	
	@FindBy(xpath = "//*[@id='header_main']/div/div/strong/a/img")
	WebElement sampleLink;
	
	@FindBy(xpath = "//img[@alt='GlobalLogic']")
	WebElement ComapanyName;
	
	@FindBy(xpath = 	"//*[@id='contact']")
	WebElement ComapanyContact;
	
	@FindBy(xpath = "//div[@class='comp-info-detail']/span")
	WebElement ComapanyAddress;
		
	@FindBy(xpath = "//div[@id='contact']")
	WebElement ContactButton;
	
	@FindBy(xpath = "(//div[@id='contactBlock']//span)[2]")
	WebElement ComapanyAddress2;
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpButton;

	@FindBy(xpath = "//a[@class='sign-in-up-product-logo']")
	WebElement sbqLogo;

	@FindBy(xpath = "//div[@class='alert alert-danger custom-alert-error']")
	WebElement errorAlert;

	@FindBy(xpath = "//span[@class='left-menu-text-item' and contains(text(),'Users')]")
	WebElement user;

	@FindBy(xpath = "//button[@class='btn btn-mt-primary dropdown-toggle wave-effect']")
	WebElement newUser;

	@FindBy(xpath = "(//input[@class='empty ng-untouched ng-pristine ng-invalid'])[1]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@class='empty ng-untouched ng-pristine ng-invalid'])[1]")
	WebElement lastName;

	@FindBy(xpath = "(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[4]")
	WebElement userRole;

	@FindBy(xpath = "(//li[@class='ng-tns-c2-4 ui-dropdown-item ui-corner-all ng-star-inserted'])[3]")
	WebElement userSelection;

	@FindBy(xpath = "(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right'])[5]")
	WebElement language;

	@FindBy(xpath = "//span[@class='ng-tns-c2-5 ng-star-inserted' and contains(text(),'English')]")
	WebElement englishLanguage;

	@FindBy(xpath = "//label[@class='ng-tns-c2-6 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")
	WebElement selecTypeDropDown;

	@FindBy(xpath = "//span[@class='ng-tns-c2-6 ng-star-inserted' and contains(text(),'Basic')]")
	WebElement basicTypeDropDown;

	@FindBy(xpath = "//button[@class='btn btn-mt-primary' and @type='submit']")
	WebElement submitButton;

	public Scenario1Page() {

		PageFactory.initElements(driver, this);
	}
	
	public Scenario1Page homePage() throws InterruptedException {
		sendKeys(driver, textSkillDesignation, 5, "Automation Testing");
		clickOn(driver, expereinceDD, 5);
		clickOn(driver, scrollexpereinceDD, 5);
		sendKeys(driver, inputLocation, 5, "pune");
		clickOn(driver, searchButton, 5);
		Thread.sleep(10000);
		clickOn(driver, comapnyLink, 5);
		
		Thread.sleep(10000);

		// hold all window handles in array list
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		System.out.println("Company Name is : " + driver.getTitle());

//		String CompanyAddress = ComapanyAddress.getText();
//		System.out.println("Comapny Address  is : " + ComapanyAddress.getText());

		driver.close();
		
		driver.switchTo().window(newTb.get(0));

		clickOn(driver, comapnyLink2, 5);
		Thread.sleep(10000);

		// hold all window handles in array list
		ArrayList<String> newTb2 = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb2.get(1));

		//driver.switchTo().window(newTb.get(1));
		System.out.println("2nd Company Name is : " + driver.getTitle());
	    
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//clickOn(driver,ContactButton , 5);
		
		//String CompanyAddress2 = ComapanyAddress.getText();
		//System.out.println("2nd Comapny Address  is : " + CompanyAddress2);

		return new Scenario1Page();
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

