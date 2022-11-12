package com.qa.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import static com.qa.config.AutoConfig.*;

import com.qa.util.WebEventListener;

public class TestBase {
	
	protected static WebDriver driver;
	public EventFiringWebDriver eventDriver;
	public WebEventListener eventListener;
	public Properties properties;
	public Config propertiesHelper;
	public WeBDriverHelper weBDriverHelper;

	
public TestBase() {
		
	}

public void Initialize() throws Exception {
	weBDriverHelper = WeBDriverHelper.getInstance();
	propertiesHelper = Config.getInstance();
	properties = propertiesHelper.property;
	driver = weBDriverHelper.getDriver(properties);
	eventDriver = new EventFiringWebDriver(driver);
	eventListener = new WebEventListener();
	eventDriver.register(eventListener);
	eventDriver.manage().window().maximize();
	eventDriver.manage().deleteAllCookies();
	eventDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
	eventDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
	eventDriver.get(properties.getProperty("urlNaukri"));
	//Thread.sleep(timeDelay);
	//eventDriver.findElement(By.xpath("//button[@id='details-button']")).click();
	//eventDriver.findElement(By.xpath("//a[@id='proceed-link']")).click();
	//eventDriver.get(properties.getProperty("urlTestServer"));
	//eventDriver.findElement(By.xpath("//input[@id='txtEmailAddressID']")).sendKeys(properties.getProperty("username"));
	//eventDriver.findElement(By.xpath("//input[@id='pwdPasswordID']")).sendKeys(properties.getProperty("password"));
	//eventDriver.findElement(By.xpath("//button[@type='submit']")).click();
	
}

public static void log(String message) {
	Reporter.log(message, true);
}

}
