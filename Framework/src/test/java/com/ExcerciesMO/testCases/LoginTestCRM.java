package com.ExcerciesMO.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ExcerciesMO.pages.BaseClass;
import com.ExcerciesMO.pages.LoginPage;
import com.ExcerciesMO.utility.BrowserFactory;
import com.ExcerciesMO.utility.ExcelDataProvider;
import com.ExcerciesMO.utility.Helper;

public class LoginTestCRM extends BaseClass {





	@Test(priority = 1)
	public void loginApp()
	{

		logger = report.createTest("Login to orange HRM");

		String userNameXl = excel.getStringData("Login", 0, 0);
		String passWordXl = excel.getStringData("Login", 0, 1);



		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");

		loginPage.loginToOHRM(userNameXl, passWordXl);

		logger.pass("Login Done Succesfully");

	}



	
	  @Test (priority = 2) 
	  public void loginApp2() {
	  
	  logger = report.createTest("LogOut to orange HRM");
	  
	  logger.pass("LogOut Failed");
	  
	  }
	 

}
