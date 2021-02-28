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
public class CreateNewOrganisationPage extends WebDriverUtility {
	
WebDriver driver;
	
	public  CreateNewOrganisationPage(WebDriver driver){
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameTxtbx;
	
	@FindBy(name = "ship_street")
	private WebElement shipAdderssTxtbx;
	
	@FindBy(name = "ship_pobox")
	private WebElement shipPoTxtbx;
	
	@FindBy(name = "ship_city")
	private WebElement shipCityTxtbx;
	
	@FindBy(name = "ship_state")
	private WebElement shipstateTxtbx;
	
	@FindBy(name = "ship_code")
	private WebElement shipPostalCodeTxtbx;
	
	@FindBy(name = "ship_country")
	private WebElement shipCountryTxtbx;
	
	@FindBy(name = "bill_street")
	private WebElement billAdderssTxtbx;
	
	@FindBy(name = "bill_pobox")
	private WebElement billPoTxtbx;
	
	@FindBy(name = "bill_city")
	private WebElement billCityTxtbx;
	
	@FindBy(name = "bill_state")
	private WebElement billstateTxtbx;
	
	@FindBy(name = "bill_code")
	private WebElement billPostalCodeTxtbx;
	
	@FindBy(name = "bill_country")
	private WebElement billCountryTxtbx;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgNameTxtbx() {
		return orgNameTxtbx;
	}

	public WebElement getShipAdderssTxtbx() {
		return shipAdderssTxtbx;
	}

	public WebElement getShipPoTxtbx() {
		return shipPoTxtbx;
	}

	public WebElement getShipCityTxtbx() {
		return shipCityTxtbx;
	}

	public WebElement getShipstateTxtbx() {
		return shipstateTxtbx;
	}

	public WebElement getShipPostalCodeTxtbx() {
		return shipPostalCodeTxtbx;
	}

	public WebElement getShipCountryTxtbx() {
		return shipCountryTxtbx;
	}

	public WebElement getBillAdderssTxtbx() {
		return billAdderssTxtbx;
	}

	public WebElement getBillPoTxtbx() {
		return billPoTxtbx;
	}

	public WebElement getBillCityTxtbx() {
		return billCityTxtbx;
	}

	public WebElement getBillstateTxtbx() {
		return billstateTxtbx;
	}

	public WebElement getBillPostalCodeTxtbx() {
		return billPostalCodeTxtbx;
	}

	public WebElement getBillCountryTxtbx() {
		return billCountryTxtbx;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}



	
}
