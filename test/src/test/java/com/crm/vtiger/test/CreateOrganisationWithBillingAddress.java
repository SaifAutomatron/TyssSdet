package com.crm.vtiger.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.vtiger.genericutility.BaseClass;
import com.crm.vtiger.objectRepositryUtility.CreateNewOrganisationPage;
import com.crm.vtiger.objectRepositryUtility.CreatedOrganisationInfoPage;
import com.crm.vtiger.objectRepositryUtility.OrganisationPage;

/**
 * Test Case-18 Create organization With "Billing Address"
 * @author Saif
 *
 */
@Listeners(com.crm.vtiger.genericutility.MyListenerIMP.class)
public class CreateOrganisationWithBillingAddress extends BaseClass{
	
		// TODO Auto-generated constructor stub
	
	@Test(groups= {"regression"})
	public void createOrganisationWithBillingAddressTest() throws Throwable {
	
	//Step 3 & 4: Navigate to create new organisation page
	OrganisationPage orgPage=new OrganisationPage(driver);
	orgPage.navigateToCreateOrgPage(orgPage);
    
	//Step 5: creating organisation with shipping address
	CreateNewOrganisationPage createOrgPage=new CreateNewOrganisationPage(driver);
	String sheet = file.getPrpoertyData("sheetname");
	int randomnum = jutil.getRandomNumber();
	String orgName=excel.getStringExcelData(sheet, 2, 0)+randomnum;
	createOrgPage.getOrgNameTxtbx().sendKeys(orgName);
	createOrgPage.getBillAdderssTxtbx().sendKeys(excel.getStringExcelData(sheet, 2, 1));
	createOrgPage.getBillPoTxtbx().sendKeys(excel.getStringExcelData(sheet, 2, 2));
	createOrgPage.getBillCityTxtbx().sendKeys(excel.getStringExcelData(sheet, 2, 3));
	createOrgPage.getBillstateTxtbx().sendKeys(excel.getStringExcelData(sheet, 2, 4));
	createOrgPage.getBillPostalCodeTxtbx().sendKeys(excel.getStringExcelData(sheet, 2, 5));
	createOrgPage.getBillCountryTxtbx().sendKeys(excel.getStringExcelData(sheet, 2, 6));
	
	createOrgPage.getSaveBtn().click();
	
	//verify Organisation name
    CreatedOrganisationInfoPage coip = new CreatedOrganisationInfoPage(driver);
    wdutil.waitForElementVisibility(driver, coip.getSuccessfulMsg());
    String actSusccessMsg = coip.getSuccessfulMsg().getText();	
   Assert.assertTrue(actSusccessMsg.contains(orgName));
 
	}
	
	
}
