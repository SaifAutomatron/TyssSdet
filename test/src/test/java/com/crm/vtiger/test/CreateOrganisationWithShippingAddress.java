package com.crm.vtiger.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.vtiger.genericutility.BaseClass;
import com.crm.vtiger.genericutility.ExcelUtility;
import com.crm.vtiger.genericutility.FileUtility;
import com.crm.vtiger.genericutility.WebDriverUtility;
import com.crm.vtiger.objectRepositryUtility.CreateNewOrganisationPage;
import com.crm.vtiger.objectRepositryUtility.CreatedOrganisationInfoPage;
import com.crm.vtiger.objectRepositryUtility.OrganisationPage;


/**
 * Test Case-18 Create organization With "Shipping Address"
 * @author Saif
 *
 */

@Listeners(com.crm.vtiger.genericutility.MyListenerIMP.class)
public class CreateOrganisationWithShippingAddress extends BaseClass
 {
	FileUtility file=new FileUtility();
	WebDriverUtility wdutil=new WebDriverUtility();
	ExcelUtility excel=new ExcelUtility();
	
	
	@Test(groups= {"regression"})
	public void createOrganisationWithShippingAddressTest() throws Throwable {
	
	//Step 3 & 4: Navigate to create new organisation page
	OrganisationPage orgPage=new OrganisationPage(driver);
	orgPage.navigateToCreateOrgPage(orgPage);
	
	//Step 5: creating organisation with shipping address
	CreateNewOrganisationPage createOrgPage=new CreateNewOrganisationPage(driver);
	String sheet = file.getPrpoertyData("sheetname");
	int randomnum = jutil.getRandomNumber();
	String orgName=excel.getStringExcelData(sheet, 1, 0)+randomnum;
	createOrgPage.getOrgNameTxtbx().sendKeys(orgName);
	createOrgPage.getShipAdderssTxtbx().sendKeys(excel.getStringExcelData(sheet, 1, 1));
	createOrgPage.getShipPoTxtbx().sendKeys(excel.getStringExcelData(sheet, 1, 2));
	createOrgPage.getShipCityTxtbx().sendKeys(excel.getStringExcelData(sheet, 1, 3));
	createOrgPage.getShipstateTxtbx().sendKeys(excel.getStringExcelData(sheet, 1, 4));
	createOrgPage.getShipPostalCodeTxtbx().sendKeys(excel.getStringExcelData(sheet, 1, 5));
	createOrgPage.getShipCountryTxtbx().sendKeys(excel.getStringExcelData(sheet, 1, 6));
	
	createOrgPage.getSaveBtn().click();
	
	//verify Organisation name
    CreatedOrganisationInfoPage coip = new CreatedOrganisationInfoPage(driver);
    wdutil.waitForElementVisibility(driver, coip.getSuccessfulMsg());
    String actualSusccessMsg = coip.getSuccessfulMsg().getText();		    
    Assert.assertTrue(actualSusccessMsg.contains(orgName));
	}
}
