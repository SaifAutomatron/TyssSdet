package com.crm.vtiger.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Saif
 *
 */
public class DataBaseUtility {
	
	static Connection con = null;
	static ResultSet result = null;

	
	public  void connectToDB() throws Throwable {

		    Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saif", "root", "root");
	}
	
	/**
	 * closes database connection
	 * @throws SQLException
	 */
	public  void closeDb() throws SQLException {
		con.close();
	}
	

	/**
	 * getDataFromDB method to retrieve data from database as key value pairs
	 * 
	 * @param query
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static ResultSet executeQuery(String query) throws Throwable {
	

			// executing the query
			 result = con.createStatement().executeQuery(query);
				return result;
		
	}
	

	/**
	 * executes database query and returns expected data
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public static  String executeQueryAndGetData(String query ,int columnName , String expectedData) throws Throwable{
         boolean flag = false;
			result = con.createStatement().executeQuery(query);
			
		while (result.next()) {
			  		if(result.getString(columnName).equals(expectedData)) {
			  			flag= true;
			  			break;
			  		}
		}
			
		
		if(flag) {
			System.out.println(expectedData + "===> data verified in data base table");
			return expectedData;
		}else {
			System.out.println(columnName + "===> data not verified in data base table");
			return expectedData;
		}
		
		
	}

}
