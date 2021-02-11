package com.ExcerciesMO.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	File file;
	FileInputStream fis;
	Properties prop;

	public ConfigDataProvider() {

		file = new File("./Config/config.properties");

		try {
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {

			System.out.println("Not able to load Config file >>" + e.getMessage());
		} 
		
	}

	public String getDataFromConfig(String keyToSearch) {
		
		return prop.getProperty(keyToSearch);
	}
	
	public String getBrowser() {
		
		return prop.getProperty("Browser");
		
	}
	
	public String getStagingURL() {
	
		return prop.getProperty("qaURL");
		
	}

}
