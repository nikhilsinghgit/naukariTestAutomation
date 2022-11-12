package com.qa.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.util.Strings;

public class AutoConfiguration {
	
	public static Properties initAutomatioProperties() {
		Properties properties = null;
		try {
			final File file = new File(System.getProperty("user.dir") + File.separator + "Env_configs" + File.separator
					+ "Automation.Properties");
			final FileInputStream fileInput = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInput);
			final String envVal = System.getProperty("Env");
			if (!Strings.isNullOrEmpty(envVal)) {
				properties.setProperty("Environment", envVal);
			}

			fileInput.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return properties;
	}

}
