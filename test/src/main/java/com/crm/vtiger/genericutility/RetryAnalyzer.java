package com.crm.vtiger.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * 
 * @author Saif
 *
 */
public class RetryAnalyzer implements IRetryAnalyzer {
 int count=0;
 int reTryLimit=3;
	
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<reTryLimit)
		{
			count++;
			return true;
		}
		return false;
	}
	
	
	
	
	

}
