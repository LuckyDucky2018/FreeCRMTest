package com.crm.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtils;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage taskPage;
	TestUtils testUtil;

	public HomePageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception{
		initilization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		taskPage = new TasksPage();
		homePage = new HomePage();
		testUtil = new TestUtils();

	}

	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String  homePageTitle =	homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO" , "Home page title not matched");
	}

	@Test(priority=2)
	public void userNameLableTest1(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectuserName());
	}

	@Test(priority=3)
	public void contactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority=4)
	public void dealsLinkTest(){
		testUtil.switchToFrame();
		 dealsPage =	homePage.clickOnDealsLink();

	}

	@Test(priority=5)
	public void tasksLinkTest(){
		testUtil.switchToFrame();
		taskPage = homePage.clickOnTasksLink();

	}



	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
