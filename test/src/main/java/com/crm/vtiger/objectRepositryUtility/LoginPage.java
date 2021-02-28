package com.crm.vtiger.objectRepositryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericutility.FileUtility;
import com.crm.vtiger.genericutility.WebDriverUtility;
/**
 * 
 * @author Saif
 *
 */
public class LoginPage extends WebDriverUtility{
	FileUtility file=new FileUtility();
	WebDriver driver;
	
	 public LoginPage(WebDriver driver) 
	    {
			this.driver =  driver;
			PageFactory.initElements(driver, this);
		}
	
	 
	@FindBy(name = "user_name")
	private WebElement userNameTxtbx;
	
	@FindBy(name = "user_password")
	private WebElement passwordTxtbx;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	
	 
	 public void loginToAPP() throws Throwable 
	   {
			userNameTxtbx.sendKeys(file.getPrpoertyData("username"));
			passwordTxtbx.sendKeys(file.getPrpoertyData("password"));
			loginBtn.click();
		}


	public WebElement getUserNameTxtbx() {
		return userNameTxtbx;
	}

	public WebElement getPasswordTxtbx() {
		return passwordTxtbx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
}
