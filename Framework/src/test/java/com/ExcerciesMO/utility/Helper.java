package com.ExcerciesMO.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	
	//ScreenShots,  alerts, frames, windows,  Sync issues, javaScript executor
	
	
	public static String captureScreenShots(WebDriver driver) {
		
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenShot = System.getProperty("user.dir") + "/Screenshots/FreeHRM_" + getCurrentDateTime() + ".png";
		
		try {
			
			//System.currentTimeMillis()
			FileHandler.copy(sourceFile, new File(screenShot));
			System.out.println("Screenshot captured");
			
		} catch (Exception e) {

			System.out.println("Unable to capture Screenshots : " + e.getMessage());

		}
		return screenShot;
	}
	
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
		 
				
	}
	
}
