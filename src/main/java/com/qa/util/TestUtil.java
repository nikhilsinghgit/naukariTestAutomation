package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public final long TIME_DELAY = 5000;

	public JavascriptExecutor js;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public void executeRunTimeScript(String messageType, String message) throws InterruptedException {
		js = (JavascriptExecutor) driver;
		String filePath = System.getProperty("user.dir") + "/src/main/java/com/sbq" + "/qa/util/jquery.min.js";
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';" + "jquery.src ="
				+ filePath + ";" + "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(TIME_DELAY);

		String filePathGrowl = System.getProperty("user.dir") + "/src/main/java/com/sbq" + "/qa/util/jquery.min.js";
		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript(" + filePathGrowl + ")");

		// Use jQuery to add jquery-growl styles to the page
		String filePathGrowlCss = System.getProperty("user.dir") + "/src/main/java/com/sbq" + "/qa/util/jquery.min.js";
		js.executeScript("$('head').append('<link rel=\"stylesheet\" " + "href= " + filePathGrowlCss + " /"
				+ "type=\"text/css\" />');");
		Thread.sleep(TIME_DELAY);
		// jquery-growl w/ no frills
		js.executeScript("$.growl({ title: 'GET', message: '/' });");

		if (messageType.equals("error")) {
			js.executeScript("$.growl.error({ title: 'ERROR', message: '" + message + "' });");
		} else if (messageType.equals("info")) {
			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
		} else if (messageType.equals("warning")) {
			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		} else
			System.out.println("no error message");
		Thread.sleep(TIME_DELAY);
	}


}
