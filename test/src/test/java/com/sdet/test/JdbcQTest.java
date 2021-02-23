package com.sdet.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JdbcQTest {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
	     try {
					/*step-1  : load or register the data base*/
					Driver driverRef = new Driver();
					DriverManager.registerDriver(driverRef);
					
					/*step-2  : connect to database*/
					 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/saif", "root", "root");
					System.out.println("Database Connected");
					
					/*step-3  : create/issue SQL statement*/
					Statement stat = connection.createStatement();
					String query = "select * from sdet";
					
					/*step-4  : execute query*/
					 ResultSet resultSet =  stat.executeQuery(query);
					   while (resultSet.next()) {
						  System.out.println(resultSet.getNString(1) + "\t" + resultSet.getNString(2)+ "\t" + resultSet.getInt(3));
						
				       }
	          }catch (Exception e) {
					       e.printStackTrace();
				   }finally {
				 		/*step-5  : close the Connection*/
					   connection.close();
						System.err.println("Connection closed");
					}


	}

}
