package com.crm.vtiger.genericutility;

import java.io.FileInputStream;

import java.util.Properties;

/**
 * 
 * @author Saif
 *
 */
public class FileUtility {
	/**
	 * 
	 * @param key
	 * @return Returns value according to key from property file
	 * @throws Exception
	 */
	public String getPrpoertyData(String key) throws Exception
	{
		
	Properties p=new Properties();
	p.load(new FileInputStream(PathConst.PROPFILEPATH));
	return p.getProperty(key);
	}

}
