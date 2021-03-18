package org.SalesForceTestAutomation.pageObject;

import java.util.concurrent.TimeUnit;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.locators.Locators.Jira_locators;
import org.SalesForceTestAutomation.locators.Locators.SF_Locators;
import org.SalesForceTestAutomation.utilities.CommonFunctions;
import org.SalesForceTestAutomation.utilities.ExtentReport;
import org.SalesForceTestAutomation.utilities.ReadPropertyFiles;
import org.SalesForceTestAutomation.utilities.ScreenCaptureUtilies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class Jira_TestCase_PageObject extends TestBase implements Jira_locators {
	
	
		// Get jira URL from Property File
		ReadPropertyFiles readPro = new ReadPropertyFiles();
		String jiraURL_prefix = readPro.get_JiraTestPage();
		
		//new tab function to load Jira test case
		CommonFunctions CF1 = new CommonFunctions();
		
	
		//FAILED test - Go to Jira test case page, change status to failed, and close tab
		public void jira_updateToFailed(String jira_issueID) throws InterruptedException {
			
			System.out.println("Opening testcase in Jira");
			CF1.openNewTab();
			CF1.goTab(1);
			String jiraURL = (jiraURL_prefix + jira_issueID);		
			driver.get(jiraURL);
			driver.manage().getCookies();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

			//main link for test status
			String menuValue = driver.findElement(By.xpath(statusMenuDropdown)).getText();
			System.out.println("Current test status: " + menuValue);
					
				//status conditions below
				if(menuValue.equalsIgnoreCase("In Progress"))
				{
					driver.findElement(By.xpath(statusMenuDropdown)).click();
					//driver.findElement(By.xpath(passedLink)).click();	 //use this line in real scenario
					driver.findElement(By.xpath(failedLink)).click();	
					System.out.println("Jira test case status changed to Failed");
					Thread.sleep(2000);
					driver.close();
				}
			
				else if( menuValue.equalsIgnoreCase("Deferred") | menuValue.equalsIgnoreCase("Blocked")  )
				{
					driver.findElement(By.xpath(statusMenuDropdown)).click();
					driver.findElement(By.xpath(workinProgressLink)).click();
					driver.findElement(By.xpath(statusMenuDropdown)).click();
					driver.findElement(By.xpath(failedLink)).click();	
						
					System.out.println("Jira test case status changed to Failed");
					Thread.sleep(2000);
					driver.close();
				}
				
				else if( menuValue.equalsIgnoreCase("Cancelled") |  menuValue.equalsIgnoreCase("Pass"))
				{
					System.out.println("Test is already in passed or cancelled status.");
				}
				
				else
				{
					System.out.println("Test is already in Failed status, or no value found in Test status dropdown");
				}
			
				//ScreenCaptureUtilies.captureScreenshot(driver, "Jira page for Test case");
				//ExtentReport.logStat(Status.PASS, "Navigated To Jira Test case");
			}
			

		
		
		//PASSED test - Go to Jira test case page, change status to passed, and close tab
		public void jira_updateToPassed(String jira_issueID) throws InterruptedException {
			
			System.out.println("Opening testcase in Jira");
			CF1.openNewTab();
			CF1.goTab(1);
			String jiraURL = (jiraURL_prefix + jira_issueID);		
			driver.get(jiraURL);
			driver.manage().getCookies();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

			//main link for test status
			String menuValue = driver.findElement(By.xpath(statusMenuDropdown)).getText();
			System.out.println("Current test status: " + menuValue);		
			
			if(menuValue.equalsIgnoreCase("In Progress"))
			{
				driver.findElement(By.xpath(statusMenuDropdown)).click();
				driver.findElement(By.xpath(deferredLink)).click();	//update to passedLink in real sceanrio
				System.out.println("Jira test case status changed to Passed");
				Thread.sleep(2000);
				driver.close();
			}

			else if( menuValue.equalsIgnoreCase("Fail") | menuValue.equalsIgnoreCase("Blocked") | menuValue.equalsIgnoreCase("Deferred")  )
			{
				driver.findElement(By.xpath(statusMenuDropdown)).click();
				//driver.findElement(By.xpath(statusMenuLink)).click();
				driver.findElement(By.xpath(workinProgressLink)).click();
				driver.findElement(By.xpath(statusMenuDropdown)).click();
				driver.findElement(By.xpath(deferredLink)).click();	//change to passedLink in real scenario
					
				System.out.println("Jira test case status changed to Passed");
				Thread.sleep(2000);
				driver.close();
			}
			
			else if( menuValue.equalsIgnoreCase("Cancelled") |  menuValue.equalsIgnoreCase("Pass"))
			{
				System.out.println("Test is already in passed or cancelled status.");
			}
			
			else
			{
				System.out.println("Test is already in Passed status, or no value found in Test status dropdown");
			}
		
			//ScreenCaptureUtilies.captureScreenshot(driver, "Jira page for Test case");
			//ExtentReport.logStat(Status.PASS, "Navigated To Jira Test case");
		}
		
		//BLOCKED test - Go to Jira test case page, change status to blocked, and close tab
		public void jira_updateToBlocked(String jira_issueID) throws InterruptedException {
			
			System.out.println("Opening testcase in Jira");
			CF1.openNewTab();
			CF1.goTab(1);
			String jiraURL = (jiraURL_prefix + jira_issueID);		
			driver.get(jiraURL);
			driver.manage().getCookies();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

			driver.findElement(By.xpath(statusMenuLink)).click();
			driver.findElement(By.xpath(blockedLink)).click();	
			System.out.println("Jira test case status changed to Blocked");
			Thread.sleep(2000);
			driver.close();
			
			//ScreenCaptureUtilies.captureScreenshot(driver, "Jira page for Test case");
			//ExtentReport.logStat(Status.PASS, "Navigated To Jira Test case");
		}
		
		//DEFERRED test - Go to Jira test case page, change status to Deferred, and close tab
		public void jira_updateToDeferred(String jira_issueID) throws InterruptedException {
			
			System.out.println("Opening testcase in Jira");
			CF1.openNewTab();
			CF1.goTab(1);
			String jiraURL = (jiraURL_prefix + jira_issueID);		
			driver.get(jiraURL);
			driver.manage().getCookies();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

			driver.findElement(By.xpath(statusMenuLink)).click();
			driver.findElement(By.xpath(deferredLink)).click();	
			System.out.println("Jira test case status changed to Deferred");
			Thread.sleep(2000);
			driver.close();
			
			//ScreenCaptureUtilies.captureScreenshot(driver, "Jira page for Test case");
			//ExtentReport.logStat(Status.PASS, "Navigated To Jira Test case");
		}
		
		//WIP status - Go to Jira test case page, change status to workinProgress, and close tab
		public void jira_updateToWorkinProgress(String jira_issueID) throws InterruptedException {
			
			System.out.println("Opening testcase in Jira");
			CF1.openNewTab();
			CF1.goTab(1);
			String jiraURL = (jiraURL_prefix + jira_issueID);		
			driver.get(jiraURL);
			driver.manage().getCookies();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

			driver.findElement(By.xpath(statusMenuLink)).click();
			driver.findElement(By.xpath(workinProgressLink)).click();	
			System.out.println("Jira test case status changed to Work in progress");
			Thread.sleep(2000);
			//driver.close();
			
			//ScreenCaptureUtilies.captureScreenshot(driver, "Jira page for Test case");
			//ExtentReport.logStat(Status.PASS, "Navigated To Jira Test case");
		}

}
