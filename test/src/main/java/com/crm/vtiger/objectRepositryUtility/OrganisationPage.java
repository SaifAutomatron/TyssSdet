package com.crm.vtiger.objectRepositryUtility;

import java.util.List;

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
public class OrganisationPage extends WebDriverUtility {
	WebDriver driver;
	
	public OrganisationPage(WebDriver driver) 
    {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table[@class='hdrTabBg']//td/a[text()='Organizations']")
	private WebElement organisationTab;
	
	@FindBy(xpath = "//a/img[@title='Create Organization...']")
	private WebElement createOrganisationBtn;
	
	@FindBy(name = "search_text")
	private WebElement orgSearchTxtbx;
	
	public WebElement getOrgSearchTxtbx() {
		return orgSearchTxtbx;
	}

	@FindBy(xpath = "//td[@class='searchAlph']")
	private List<WebElement>  alphabetBtns;
	
	public WebElement getOrganisationTab() {
		return organisationTab;
	}

	public WebElement getCreateOrganisationBtn() {
		return createOrganisationBtn;
	}
	
	public List<WebElement> getAlphabetBtns() {
		return alphabetBtns;
	}
   /**
    * clicks on organisation tab and then on create organisation button
    * @param orgPage
    */
   public void navigateToCreateOrgPage(OrganisationPage orgPage)
   {
	    // Navigate to organisation
		orgPage.getOrganisationTab().click();
	    
		// Navigate to create new organisation 
		orgPage.getCreateOrganisationBtn().click();
   }
	
	
	

}
