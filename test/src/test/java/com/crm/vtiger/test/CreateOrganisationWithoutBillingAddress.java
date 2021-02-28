package com.crm.vtiger.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.vtiger.genericutility.BaseClass;
import com.crm.vtiger.objectRepositryUtility.CreateNewOrganisationPage;
import com.crm.vtiger.objectRepositryUtility.CreatedOrganisationInfoPage;
import com.crm.vtiger.objectRepositryUtility.OrganisationPage;

/**
 * Test Case-21 Create organization Without "Billing Address"
 * @author Saif
 *
 */
public class CreateOrganisationWithoutBillingAddress extends BaseClass{

	
	@Test
	public void createOrganisationWithoutBillingAddressTest() throws Throwable {
	
    //Step 3 & 4: Navigate to create new organisation page
	OrganisationPage orgPage=new OrganisationPage(driver);
	orgPage.navigateToCreateOrgPage(orgPage);
	
	//Step 5: creating organisation without billing address
	int randomnum = jutil.getRandomNumber();
	CreateNewOrganisationPage createOrgPage=new CreateNewOrganisationPage(driver);
	createOrgPage.getOrgNameTxtbx().sendKeys(excel.getStringExcelData(file.getPrpoertyData("sheetname"), 4, 0)+randomnum);
	createOrgPage.getSaveBtn().click();
	
	//verify Organisation name
    CreatedOrganisationInfoPage coip = new CreatedOrganisationInfoPage(driver);
    wdutil.waitForElementVisibility(driver, coip.getSuccessfulMsg());
    String actSusccessMsg = coip.getSuccessfulMsg().getText();		    
    Assert.assertTrue(actSusccessMsg.contains(excel.getStringExcelData(file.getPrpoertyData("sheetname"), 4, 0)));
	
    
	}

}
