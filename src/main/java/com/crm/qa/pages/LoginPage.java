package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory or OR
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "html/body/div[2]/div/div[3]/form/div/div/input")
	WebElement loginBtn;

	@FindBy(xpath = "//button[contains(text(),'SignUp')]")
	WebElement signUpBtn;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;

	public LoginPage(){

		PageFactory.initElements(driver, this);
	}


	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}

	public HomePage login(String un , String pwd) throws Exception{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginBtn.click();

		return new HomePage();
	}







}
