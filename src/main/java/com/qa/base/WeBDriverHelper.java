package com.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WeBDriverHelper {
	private static WeBDriverHelper instanceDriver = null;
	
	WeBDriverHelper() {
	}
	
	public WebDriver getDriver(Properties properties) {
		WebDriver driver = null;
		try {
			String browserName = properties.getProperty("browser");
			if (browserName.equals("chrome")) {

				Config config = Config.getInstance();
				String filePath = config.getFilePath();
				System.setProperty("webdriver.chrome.driver", filePath);
				driver = new ChromeDriver();
			} else if (browserName.equals("FF")) {
				Config config = Config.getInstance();
				String filePath = config.getFilePath();
				System.setProperty("webdriver.gecko.driver", filePath);
				driver = new FirefoxDriver();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	public static WeBDriverHelper getInstance() {
		if (instanceDriver == null)
			instanceDriver = new WeBDriverHelper();
		return instanceDriver;

	}

}
