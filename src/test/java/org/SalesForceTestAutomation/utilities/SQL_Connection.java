package org.SalesForceTestAutomation.utilities;

import java.sql.Connection; //make sure it is THIS library to be imported for Connection class
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SQL_Connection  {
	

	@Test
	public static ResultSet SQL_connector(String Sql_query) throws SQLException, ClassNotFoundException, InterruptedException
	{
	

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		System.out.println("connecting to server..." + "\n");
		
		String host = "DEV-HQWD-SQL02"; 	//local , DEV-HQWD-SQL02 , WSPF1EBU0Y
		String instance = "";
		String port = "1433";				//1433, 1434
		String dbName = "BBCRM_Slalom";
		String dbUserName = ""; 	
		String dbPass = "";

		String url1 = ("jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dbName + ";integratedSecurity=true");
		String url2 =  "jdbc:sqlserver://WSPF1EBU0Y\\MSSQLSERVER;databaseName=BBCRM_Slalom"; //without port
		String url3 = "jdbc:sqlserver://DEV-HQWD-SQL02\\MSSQLSERVER;databaseName=BBCRM_Slalom";
		String url4 = "jdbc:sqlserver://DEV-HQWD-SQL02:1433;databaseName=BBCRM_Slalom"; //with port
		String url5 = "jdbc:sqlserver://DEV-HQWD-SQL02:1433;databaseName=BBCRM_Slalom;integratedSecurity=true"; //with port
		//format       jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
		
		String query1 = "SELECT TOP (10) [BUSINESSPROCESSOUTPUT_PKID], [CONSTITUENTID],[CONSTITUENTNAME]\r\n"
				+ "  FROM [BBCRM_Slalom].[dbo].[CORRESPONDENCE_d946ff16_4e57_4498_9438_d1b1c07afbc8]";
		
		
		//connection object
		Connection sqlConnect = DriverManager.getConnection(url1);
	
		//statement for queries to travel
		Statement sqlStatement = sqlConnect.createStatement();
		
		//send queries and return result
		ResultSet sqlResult = sqlStatement.executeQuery(Sql_query);
	
				
				//the above result set can be called in the test case as below
				//ResultSet myResults = SQL_Connection.SQL_connector(query);
				//while(myResults.next())...
				 
				//to display results in this class, uncomment below loop
				
				while(sqlResult.next())
				{
						String field1 = sqlResult.getString(1);
						String field2 = sqlResult.getString(2);
						String field3 = sqlResult.getString(3);
						System.out.println(field1);
						System.out.println(field2);
						System.out.println(field3 + "\n");
				}
				
		return sqlResult;
	
						
	}
}
