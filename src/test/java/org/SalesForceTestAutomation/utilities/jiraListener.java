package org.SalesForceTestAutomation.utilities;

import java.io.IOException;
import java.util.Base64;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.SalesForceTestAutomation.utilities.jiraUtils;
import org.SalesForceTestAutomation.utilities.jiraServiceProvider;
import org.SalesForceTestAutomation.utilities.JiraLogString;


public class jiraListener implements ITestListener {
	
	//jira variables
	String url=null;
	String email=null;
	String token=null;
	String projectKey=null;
	jiraServiceProvider jiraprovider=null;
	jiraUtils jiraPolicy=null;
	
	//Object of testcase update method
	JiraIssueUpdate jiraUpdate = new JiraIssueUpdate();	

	
	//Jira credentials - input here
	public void JiraListener()
	{
		this.url="https://plancanada.atlassian.net/rest/api/3/issue";
		this.email="dsathavara@plancanada.ca";
		this.token="Z30xv1F2pllHFwdlT9BuAA25";
		this.projectKey="IWD";
	}
	
	//get jiraServiceProvider method - no input here
	public void get_credentials(ITestResult result)
	{
		//below 2 lines added 
		jiraprovider = new jiraServiceProvider();
		jiraprovider.JiraServiceProvider(this.url, this.email, this.token ,this.projectKey);
		jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(jiraUtils.class);	
	}
	
	  
	public void onTestSuccess(ITestResult result) {
	  
			//start test case update
			JiraIssueUpdate jiraUpdate = new JiraIssueUpdate();	
			
			//get the test name to use in JiraIssueUpdate and update test case
			String testFullName = result.getTestClass().getRealClass().getSimpleName();  
			String[] split = testFullName.split("_");
			String testNamePrefix = split[0];
			String testNameSuffix = split[1];
			String testShortName = (testNamePrefix + "-" + testNameSuffix);
							
			try {				
				
				System.out.println("Test passed");	
				jiraUpdate.updateIssue(testShortName, "passed");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	 

	public void onTestFailure(ITestResult result) {
		
		get_credentials(result);		
		JiraIssueUpdate jiraUpdate = new JiraIssueUpdate();
		
		boolean creatIssue =jiraPolicy.createJiraBug();
        if (creatIssue==true) {
            
            try {
              	
            	System.out.println("issue ready for JIRA:" + creatIssue);
            	            	
            	//Jira issue linking types for RELATE
    			String link_name="Relates";
    			String link_type="relates to"; 
    			String issue_type="Bug";

            	/* Use this to DUPLICATE issue
    			String issueToLinkKey="IWD-35";
    			String issue_name="Duplicate";
    			String link_type="Duplicated by"; //other options are blocked by, blocks...
    			String issue_type="Test";
    			*/
    			
    			//name for the testcase to be linked with bug
    			String testFullName = result.getTestClass().getRealClass().getSimpleName();
    			String[] split = testFullName.split("_");
    			String testNamePrefix = split[0];
    			String testNameSuffix = split[1];
    			String testShortName = (testNamePrefix + "-" + testNameSuffix);
    			
    			//Summary and descriptions
    			String issueSummary = ("Test case " + testShortName + " failed " + "at method - ").concat(result.getMethod().getConstructorOrMethod().getMethod().getName());
    			//String issueDescription = ("Due to the following failure in the method").concat(result.getThrowable().getMessage());
    			//String issueDescription2 = JiraLogString.JiraLogString;
  		
    			//update test status in jira and create bug
    			jiraUpdate.updateIssue(testShortName, "failed");
    			jiraprovider.createJiraTicket(issue_type, issueSummary, JiraLogString.JiraLogString , "Dhaval", testShortName, link_name, link_type);
    			
            } catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
            }
        

	}

	
	/*
	 * @Override public void onTestStart(ITestResult result) {
	 * 
	 * }
	 */
	/*
	 * @Override public void onTestSkipped(ITestResult result) {}
	 * 
	 * @Override public void onTestFailedButWithinSuccessPercentage(ITestResult
	 * result) {}
	 * 
	 * @Override public void onStart(ITestContext context) {}
	 * 
	 * @Override public void onFinish(ITestContext context) {}
	 */

}








