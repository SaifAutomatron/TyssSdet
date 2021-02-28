package com.crm.vtiger.objectRepositryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericutility.WebDriverUtility;
/**
 * 
 * @author Saif
 *
 */
public class HomePage extends WebDriverUtility {
	WebDriver driver;
	
	public HomePage(WebDriver driver) 
    {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td/img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutEle;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLnk;
	
	public WebElement getContactLnk() {
		return contactLnk;
	}


	public WebElement getSignOutIcon() {
		return signOutEle;
	}

	public WebElement getSignOutEle() {
		return signOutEle;
	}
	
	public void logout() throws Throwable
	{
		waitAndClick(adminImg);
		signOutEle.click();
	}

}
