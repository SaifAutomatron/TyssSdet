package com.crm.vtiger.test;


import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.vtiger.genericutility.BaseClass;
import com.crm.vtiger.objectRepositryUtility.OrganisationPage;

/**
 * Test Case-21 Search organization by "Alphabets"
 * @author Saif
 *
 */
@Listeners(com.crm.vtiger.genericutility.MyListenerIMP.class)
public class SearchOrganisationWithAlbhabets extends BaseClass {
	
	@Test(retryAnalyzer=com.crm.vtiger.genericutility.RetryAnalyzer.class)
	public void searchOrganisationWithAlbhabetsTest() throws Throwable
	{
		
		//Step 3: Navigate to organisation
		OrganisationPage orgPage=new OrganisationPage(driver);
		orgPage.getOrganisationTab().click();

        //Step 4: Search organisation by "Alphabets"
		List<WebElement> alphabetElements = orgPage.getAlphabetBtns();
		LinkedList<String> ll=new LinkedList<String>();
		for(WebElement wb:alphabetElements )
		{
			ll.add(wb.getText());
			wb.click();
		}
        
		//validation
//		Assert.assertEquals(ll.getLast(), "Z");
		Assert.fail();

	}

}
