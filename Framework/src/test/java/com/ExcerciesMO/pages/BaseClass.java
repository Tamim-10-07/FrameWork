package com.ExcerciesMO.pages;

import java.io.File;
import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.ExcerciesMO.utility.BrowserFactory;
import com.ExcerciesMO.utility.ConfigDataProvider;
import com.ExcerciesMO.utility.ExcelDataProvider;
import com.ExcerciesMO.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	
	@BeforeSuite
	public void setUpSuite() {
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter  extent = new ExtentHtmlReporter
				(new File(System.getProperty("user.dir") + "/Reports/FreeHRM"+ Helper.getCurrentDateTime() +".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
	}
	
	
	@BeforeClass
	public void setUp() {

		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());

		System.out.println(driver.getTitle());
	}

	@AfterClass
	public void tearDown() {

		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMehthod(ITestResult result) throws IOException {
		
		//(result.getStatus() == ITestResult.FAILURE) or (!result.isSuccess())
		
		if(result.getStatus() == ITestResult.FAILURE) {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShots(driver)).build());
		}
		
		report.flush();
		
	}
	
	
}
