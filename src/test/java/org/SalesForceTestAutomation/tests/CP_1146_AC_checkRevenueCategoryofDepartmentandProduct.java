package org.SalesForceTestAutomation.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.pageObject.SalesForce_HomeScreen;
import org.SalesForceTestAutomation.pageObject.SalesForce_Opportunity;
import org.SalesForceTestAutomation.utilities.ExtentReport;
import org.SalesForceTestAutomation.utilities.ReadPropertyFiles;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class CP_1146_AC_checkRevenueCategoryofDepartmentandProduct extends TestBase {

	ReadPropertyFiles readPro = new ReadPropertyFiles();
	String url = readPro.getSalesForceURL();
	String userName = readPro.getSalesForceUserName();
	String password = readPro.getSalesForcePassword();
	String opportunityName = readPro.getOpportunityName();
	String accountName = readPro.getAccountName();
	String stage = readPro.getStage();
	String amount = readPro.getOpportunityAmount();

	static SalesForce_HomeScreen homeScreen;
	static SalesForce_Opportunity opportunity;

	@BeforeMethod
	public void initPages() {
		homeScreen = PageFactory.initElements(driver, SalesForce_HomeScreen.class);
		// SalesForce_HomeScreen homeScreen = new SalesForce_HomeScreen();

		opportunity = PageFactory.initElements(driver, SalesForce_Opportunity.class);
		// SalesForce_Opportunity opportunity = new SalesForce_Opportunity();
	}

	@Test(priority = 1)
	public void verifyDepartmentandProduct() {
		try {
			
			String closeDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			
			// Start Test
			System.out.println("Step 1:Start Test:CP_1146_AC_checkRevenueCategoryofDepartmentandProduct ");
			logger.info("Step 1:Start Test:CP_1146_AC_checkRevenueCategoryofDepartmentandProduct ");
			ExtentReport.initialisation("CP_1146_AC_checkRevenueCategoryofDepartmentandProduct ");

			// Launch Browser and URL
			openURL(url);
			ExtentReport.logStat(Status.PASS, "Step 1: Url open in browser.");
			// Login SalesForce
			homeScreen.loginSalesForce(userName, password);
			System.out.println("Step 2:Enter Username");
			ExtentReport.logStat(Status.PASS, "Step 2:Enter Username");
			logger.info("Step 2:Enter Username");
			System.out.println("Step 3:Enter Password");
			ExtentReport.logStat(Status.PASS, "Step 3:Enter Password");
			logger.info("Step 3:Enter Password");

			// Open Non Profit Success Pack App.
			homeScreen.openNonprofitSuccessPackApp();
			System.out.println("Open Non Profit Success Pack App");
			
			// Navigate to the Opportunities Field.
			opportunity.navigateToOpportunities();
			System.out.println("Navigate to the Opportunities Field.");
			
			// Click on the New Button
			opportunity.opportunityNewButton_field.click();
			System.out.println("Click on the New Button");

			// Click on the Next button
			opportunity.newOpportunityNextButton_field.click();
			System.out.println("Click on the New Button");
			
			// Enter Opportunity Name
			opportunity.opportunityName_field.sendKeys(opportunityName);
			System.out.println("Click on the New Button");
			
			// Search Account Name
			opportunity.opportunityAccountName_field.click();
			opportunity.opportunityAccountName_field.sendKeys(accountName);
			opportunity.opportunityAccountName_field.click();
			Thread.sleep(3000);
			opportunity.opportunityAccountName_field.sendKeys(Keys.ARROW_DOWN);
			opportunity.opportunityAccountName_field.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			// Choose Close Date
			opportunity.closeDate_field.sendKeys(closeDate);
			Thread.sleep(3000);
			System.out.println("Choose Close Date");
			
			// Select Stage
			// stage_field.sendKeys(stage);
			opportunity.stage_field.click();

			if (stage.equalsIgnoreCase("Pledged")) {
				opportunity.pledgedStage_field.click();
			} else if (stage.equalsIgnoreCase("Closed Won")) {
				opportunity.closedWon_field.click();
			} else if (stage.equalsIgnoreCase("Declined")) {
				opportunity.declined_field.click();
			} else if (stage.equalsIgnoreCase("Closed Lost")) {
				opportunity.closedLost_field.click();
			} else {
				System.out.println("Stage Not Found : " + stage);
				ExtentReport.logStat(Status.FAIL, "Stage Not Found : " + stage);
			}
			System.out.println("Select Stage");
			
			
			// Get all data of department dropdwon.
			String[] allOptionofDepartment = opportunity.getValueofDepartmentDropdwon();
			System.out.println(allOptionofDepartment);
			
			// Get all data of product dropdown.
			String[] allOptionofProduct= opportunity.getValueofProductDropdwon();
			System.out.println(allOptionofProduct);
	
		
		}

		catch (Exception e) {
			ExtentReport.logStat(Status.FAIL, "'CP_1146_AC_checkRevenueCategoryofDepartmentandProduct' test got failed and the error is - " + e);
			Assert.assertEquals(false, true);
		}
	}
}
