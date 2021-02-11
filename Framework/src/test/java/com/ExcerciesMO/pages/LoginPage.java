package com.ExcerciesMO.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
	WebDriver driver;

	//This is new commit from local repository
	public LoginPage(WebDriver lDriver) {
	
		this.driver = lDriver ; 
		
		
	}
	
	@FindBy(id = "txtUsername") WebElement uName;
	@FindBy(id = "txtPassword") WebElement pWord;
	@FindBy(name = "Submit") WebElement loginBtn;
	
	
	public void loginToOHRM(String userNameApp ,  String passWordApp) {
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
					
		}
		
		uName.sendKeys(userNameApp);
		pWord.sendKeys(passWordApp);
		loginBtn.click();
	}
	
	
}
