package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtils;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase(){

		try {
			prop = new Properties();
			FileInputStream fi = new FileInputStream("C:\\WorkspaceAssignments\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\configue\\configue.properties");
			System.out.println("file found" + fi);
			prop.load(fi);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		} catch (IOException e) { // this exception is for prop.load
		
			System.out.println("asdasdasd");
		//
			e.printStackTrace();
		}

	}
	
	public static void initilization(){
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrom.driver","C:\\Users\\Swapna\\Desktop\\SWAPNA\\Jar Files\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox")){
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
