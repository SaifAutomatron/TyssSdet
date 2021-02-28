package com.crm.vtiger.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.vtiger.objectRepositryUtility.HomePage;
import com.crm.vtiger.objectRepositryUtility.LoginPage;

/**
 * 
 * @author Saif
 *
 */
public class BaseClass {
	
	/*Object creation*/
	public FileUtility file = new FileUtility();
	public ExcelUtility excel = new ExcelUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wdutil = new WebDriverUtility();
	public DataBaseUtility dbutil = new DataBaseUtility();
	public WebDriver driver;
	
	@BeforeSuite
	public void configBeforeSuite() throws Throwable {
		dbutil.connectToDB();
	}
	
	@BeforeClass
	public void configBeforeClass() throws Throwable {
		/* launch the Browser*/
		/*read Common Data*/
		/* Step 1: navigate to application */
		String URL = file.getPrpoertyData("url");

		String BROWSER = file.getPrpoertyData("browser");
		
		 if(BROWSER.equals("firefox")) {
		    driver = new FirefoxDriver();
		 }else if(BROWSER.equals("chrome")) {
			 driver = new ChromeDriver();
		 }else if(BROWSER.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver();
		 }
		
		 wdutil.waitForPageToLoad(driver);
		 driver.get(URL);
	}
	
	
	@BeforeMethod
	public void configBeforeMtd() throws Throwable {
		/*step 2 : login to Application*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToAPP();
	}
	
	@AfterMethod
	public void configAfterMethod() throws Throwable {
		HomePage hp = new HomePage(driver);
	      /*step-* : logout */
			  hp.logout();
    }
	
	@AfterClass
	public void configAfterClass() {
		driver.close();
	}
	
	@AfterSuite
	public void configAfterSuite() throws Throwable {
		dbutil.closeDb();
		
	}

}
