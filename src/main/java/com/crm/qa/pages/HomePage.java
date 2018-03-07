package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//@FindBy(xpath="//td[conatins(text(),'User: Naveen K')]")
	@FindBy(xpath="html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
  //Initializing the page objects 
	
	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectuserName(){
		
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnNewContact(){
		
		Actions act = new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	
	
	

}
