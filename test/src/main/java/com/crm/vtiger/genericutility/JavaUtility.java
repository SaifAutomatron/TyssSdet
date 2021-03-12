package com.crm.vtiger.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Saif
 *
 */
public class JavaUtility {
	/**
	 * returns random integer number between 1-1000
	 * @return int Randomnumber
	 */
	public int getRandomNumber()
	{
		Random rd=new Random();
	    int randomnum=rd.nextInt(1000);

	        return randomnum;
	}
	/**
	 * returns current date in the form of string array
	 * @return String dateArray
	 */
	public String[] getCurrentDateArray()
	{
		Date date=new Date();
		String strDate = date.toString();
		String[] strDateArray = strDate.split("");
		
		return strDateArray;
	}
	public String getCurrentDate()
	{
		Date date=new Date();
		String strDate = date.toString();
		
		
		return strDate;
	}

}
