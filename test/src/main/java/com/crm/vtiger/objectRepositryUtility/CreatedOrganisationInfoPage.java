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
public class CreatedOrganisationInfoPage extends WebDriverUtility{
	
WebDriver driver;
	
	public  CreatedOrganisationInfoPage(WebDriver driver){
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(className = "dvHeaderText")
	private WebElement successfulMsg;

	public WebElement getSuccessfulMsg() {
		return successfulMsg;
	}

}
