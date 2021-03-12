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

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * contains webdriver specific utilities
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
	public static WebDriver driver;
	
	@BeforeSuite(groups= {"smoke","regerssion"})
	public void configBeforeSuite() throws Throwable {
		dbutil.connectToDB();
	}
	
	@BeforeClass(groups= {"smoke","regerssion"})
	public void configBeforeClass( ) throws Throwable {
		/* launch the Browser*/
		/*read Common Data*/
		/* Step 1: navigate to application */
		String URL = file.getPrpoertyData("url");

		String BROWSER = file.getPrpoertyData("browser");
		
		 if(BROWSER.equals("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		 }else if(BROWSER.equals("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }else if(BROWSER.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver();
		 }
		
		 wdutil.waitForPageToLoad(driver);
		 driver.get(URL);
	}
	
	
	@BeforeMethod(groups= {"smoke","regerssion"})
	public void configBeforeMtd() throws Throwable {
		/*step 2 : login to Application*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToAPP();
	}
	
	@AfterMethod(groups= {"smoke","regerssion"})
	public void configAfterMethod() throws Throwable {
		HomePage hp = new HomePage(driver);
	      /*step-* : logout */
			  hp.logout();
    }
	
	@AfterClass(groups= {"smoke","regerssion"})
	public void configAfterClass() {
		driver.close();
	}
	
	@AfterSuite(groups= {"smoke","regerssion"})
	public void configAfterSuite() throws Throwable {
		dbutil.closeDb();
		
	}

}
