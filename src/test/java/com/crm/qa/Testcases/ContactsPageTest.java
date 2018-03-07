package com.crm.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtils;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtils testUtil;
	String sheetName = "contacts";

	public ContactsPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception{
		initilization();
		testUtil = new TestUtils();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority=1)
	public void contactsLabelTest(){
	Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the Page");
	}

/*	@Test(priority=2)
	public void selectContactNameTest(){
		contactsPage.selectContactsByName("	Tom Peter");
	}*/

	@DataProvider
	public Object[][] getCRMTestData(){
		Object  data[][] = testUtil.getData(sheetName);
		return data;
	}

	@Test(priority=3 , dataProvider = "getCRMTestData")
	public void validateCreateNewContactLink(String firstName,String lastName,String company){
		homePage.clickOnNewContact();
		//contactsPage.createNewContact("Tom", "Peter", "Google");
		contactsPage.createNewContact(firstName, lastName, company);
	}
	
	
	/*@Test
	public void validateCreateNewContactLink(){
		homePage.clickOnNewContact();
		contactsPage.createNewContact("Tom", "Peter", "Google");
	}*/
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}

}
