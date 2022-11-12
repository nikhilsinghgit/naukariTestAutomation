package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private static Config instance;
	public Properties property;

	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
			try {
				instance.property = new Properties();
				FileInputStream fileInput = new FileInputStream(
						System.getProperty("user.dir") + "/src/main/java/com" + "/qa/config/config.properties");
				instance.property.load(fileInput);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public String getFilePath() {

		return System.getProperty("user.dir") + "/src/main/java/com" + "/qa/util/chromedriver.exe";

	}

}
