package org.SalesForceTestAutomation.tests;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.utilities.ExtentReport;
import org.SalesForceTestAutomation.utilities.ReadPropertyFiles;
import org.SalesForceTestAutomation.utilities.SQL_Connection;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo_02_sqlConnection  {
		
		
	  	@BeforeMethod public void beforeMethod()
	  	{ 
	  	System.out.println("CP_04_sqlConnection"); 
	  	}
	 
		
		
		//test steps below
		@Test()
		public void SQL_UtilityTest() throws InterruptedException, ClassNotFoundException, SQLException  
		{
			
			
			//SQL scripts below
			String query = "SELECT TOP (10) [BUSINESSPROCESSOUTPUT_PKID], [CONSTITUENTID],[CONSTITUENTNAME]\r\n"
					+ "  FROM [BBCRM_Slalom].[dbo].[CORRESPONDENCE_d946ff16_4e57_4498_9438_d1b1c07afbc8]";

						
			SQL_Connection mySql = new SQL_Connection();
			ResultSet myResults = SQL_Connection.SQL_connector(query);
			
			while(myResults.next())
			{
					String field1 = myResults.getString(1);					
					String field2 = myResults.getString(2);
					String field3 = myResults.getString(3);
					System.out.println(field1);
					System.out.println(field2);
					System.out.println(field3 + "\n");
			}
		}
}
	

