package com.sdet.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JdbcNonSelectQ {

	public static void main(String[] args) throws SQLException {
		
		Connection connection =null;
		 int result = 0;
		try {
       
				/*step-1  : load or register the data base*/
				 Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
				
				/*step-2  : connect to database*/
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/saif", "root", "root");
				System.out.println("Done");
				
				/*step-3  : create/issue SQL statement*/
				Statement stat = connection.createStatement();
				String query = "insert into sdet values('Stan','Computer Science',106)";
				
				/*step-4  : execute query*/
				 result=  stat.executeUpdate(query);
				 System.out.println(result);
				 
		}catch (Exception e) {
			
		}finally {
			if(result==0) {
				System.err.println("Table not updated==FAIL");
			}else {
				System.out.println("Table updated sucessfully==PASS");
			}
			
			/*step-5  : close the Connection*/
			connection.close();
		}

	}

}
