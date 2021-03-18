package org.SalesForceTestAutomation.tests;

import java.io.IOException;
import java.sql.Driver;

import javax.servlet.http.Cookie;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.utilities.ExtentReport;
import org.SalesForceTestAutomation.utilities.JiraIssueUpdate;
import org.SalesForceTestAutomation.utilities.JiraLogger;
import org.SalesForceTestAutomation.utilities.ReadPropertyFiles;
import org.SalesForceTestAutomation.utilities.XLUtils;
import org.SalesForceTestAutomation.utilities.jiraListener;
import org.SalesForceTestAutomation.utilities.jiraUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IWD_38_Testcase_01 extends TestBase {
	
		//initial log
	  	@BeforeMethod public void beforeMethod()
	  	{ 
	  	System.out.println("Start Test: Jira_TC01");
	  	logger.info("Start Test: Jira_TC01");
	  	}
	 
		
		//test steps below
	 	@jiraUtils(createJiraBug=true)
		@Test()
		public void salesForceTest_Login() throws InterruptedException  
		{
			//log start of test case
			logger.info("---starting salesForceTest_Login --- ");
			
			//read property file for URL data
			ReadPropertyFiles readPro = new ReadPropertyFiles();
			String sf_url = readPro.get_SF_url();
			String sf_username = readPro.get_SFusername();
			String sf_pass = readPro.get_SFpassword();
			String sf_label = readPro.get_TableLabel();
			String sf_plural = readPro.get_TablePlural();
			String sf_TableDesc= readPro.get_TableDesc();
			String newObj_url = readPro.get_SF_NewObj_url();
			
			//initialize report
			logger.info("-- started to generate extent report -- ");			
			ExtentReport.initialisation("Jira_TC01");

			
			//perform steps and fail test		
			//SalesForce_Dev_ObjectPage sfPage1 = new SalesForce_Dev_ObjectPage();
			//sfPage1.goToSalesForceDev(sf_url);
			//sfPage1.login(sf_username, sf_pass);	
			//driver.get("google.com");
			logger.info("-- test log step before failing --");	
			
			//-------------jira log test below
						
			JiraLogger JL = new JiraLogger();
			JL.addJiraLog("Step 1 of Jira test");
			JL.addJiraLog("Step 2 of Jira test");
			JL.addJiraLog("Step 3 of Jira test");
			Assert.assertTrue(false);
			Thread.sleep(2000);
					
			
			//System.out.println(this.getClass().getSimpleName());
			
			//jira test here
			//JiraIssueUpdate jiraUpdate = new JiraIssueUpdate();
			//jiraUpdate.updateIssue("passed");
					
			Thread.sleep(5000);
			//driver.close();			
			}
		
}
	

