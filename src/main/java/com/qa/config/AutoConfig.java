package com.qa.config;

import java.util.Properties;

public class AutoConfig {
	
	public Properties properties;
	
	//IDP 
		public static String countryKvkNumber = AutoConfiguration.initAutomatioProperties().getProperty("kvkNumber");
		public static String localCountryName = AutoConfiguration.initAutomatioProperties().getProperty("localCountry");
		public static String foreignCountryName = AutoConfiguration.initAutomatioProperties().getProperty("foreignCountry");
		public static String selectAdministrationName = AutoConfiguration.initAutomatioProperties().getProperty("administrationName");
		public static String selectAdministrationSbxTesting2 = AutoConfiguration.initAutomatioProperties().getProperty("selectAdministrationSbxTesting2");
		public static String selectAdministrationDemo= AutoConfiguration.initAutomatioProperties().getProperty("selectAdministrationDemo");

		
		//Base Class Constants	
		public final static long pageLoadTimeout = 20;
		public final static long implicitWait = 20;
		public final static long timeDelay = 3000;
		
		//Wait Constants
		public final static long SMALL_WAIT_TWO_MILISECONDS = 2000;
		public final static long SMALL_WAIT_THREE_MILISECONDS = 3000;
		public final static long SMALL_WAIT_FIVE_MILISECONDS = 5000;
		public final static long SMALL_WAIT_EIGHT_MILISECONDS = 8000;


}
