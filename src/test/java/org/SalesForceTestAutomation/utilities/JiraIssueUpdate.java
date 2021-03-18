package org.SalesForceTestAutomation.utilities;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.utilities.ReadPropertyFiles;
import org.SalesForceTestAutomation.locators.Locators;
import org.SalesForceTestAutomation.pageObject.Jira_TestCase_PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class JiraIssueUpdate extends TestBase  {

	//For this method to work, the class name prefix in Selenium testcase, and Jira test ID have to match
	//Example test in Selenium: "IWD_41_ValidateLogin" and in Jira: "IWD-41"  
	public void updateIssue(String issueID, String testStatus) throws InterruptedException
	{
		
		if(testStatus.equalsIgnoreCase("failed"))
		{
			Jira_TestCase_PageObject jira_TestPage = new Jira_TestCase_PageObject();
			jira_TestPage.jira_updateToFailed(issueID);	
		}
		
		else if(testStatus.equalsIgnoreCase("passed"))
		{
			Jira_TestCase_PageObject jira_TestPage = new Jira_TestCase_PageObject();
			jira_TestPage.jira_updateToPassed(issueID);
		} 

		else if(testStatus.equalsIgnoreCase("deferred"))
		{
			Jira_TestCase_PageObject jira_TestPage = new Jira_TestCase_PageObject();
			jira_TestPage.jira_updateToDeferred(issueID);
		} 

		else if(testStatus.equalsIgnoreCase("blocked"))
		{
			Jira_TestCase_PageObject jira_TestPage = new Jira_TestCase_PageObject();
			jira_TestPage.jira_updateToBlocked(issueID);
		} 
		
		
		else if(testStatus.equalsIgnoreCase("unexecuted"))
		{
			Jira_TestCase_PageObject jira_TestPage = new Jira_TestCase_PageObject();
			jira_TestPage.jira_updateToWorkinProgress(issueID);
		} 
		
		//wait before going back to window tab with the test run
		Thread.sleep(2000);
	
	}
	
}
