package org.SalesForceTestAutomation.tests;

import java.util.concurrent.TimeUnit;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.pageObject.SalesForce_HomeScreen;
import org.SalesForceTestAutomation.pageObject.SalesForce_Opportunity;
import org.SalesForceTestAutomation.pageObject.SalesForce_AccountingSubledger;
import org.SalesForceTestAutomation.utilities.ExtentReport;
import org.SalesForceTestAutomation.utilities.ReadPropertyFiles;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class CP_1115_ASL_createJournalEntriesOnDemand extends TestBase {

	ReadPropertyFiles readPro = new ReadPropertyFiles();
	String url = readPro.getSalesForceURL();
	String userName = readPro.getSalesForceAdminUserName();
	String password = readPro.getSalesForceAdminPassword();

	
	static SalesForce_HomeScreen homeScreen;
	static SalesForce_AccountingSubledger accountingSubledger;

	@BeforeMethod
	public void initPages() {
		homeScreen = PageFactory.initElements(driver, SalesForce_HomeScreen.class);
		// SalesForce_HomeScreen homeScreen = new SalesForce_HomeScreen();

		accountingSubledger = PageFactory.initElements(driver, SalesForce_AccountingSubledger.class);
		// SalesForce_Opportunity opportunity = new SalesForce_Opportunity();
	}

	@Test(priority = 1)
	public void SF_Admin_Login() throws Exception {
		try {

			// SalesForce_HomeScreen salesforce = new SalesForce_HomeScreen();
			// SalesForce_AccountingSubledger accountingSubledger = new
			// SalesForce_AccountingSubledger();

			// Start Test
			System.out.println("Step 1:Start Test: CP_1115_ASL_createJournalEntriesOnDemand");
			logger.info("Step 1:Start Test: CP_1115_ASL_createJournalEntriesOnDemand");
			ExtentReport.initialisation("CP_1115_ASL_createJournalEntriesOnDemand");

			// Launch Browser and URL
			openURL(url);
			ExtentReport.logStat(Status.PASS, "Step 1: Url open in browser.");

			// Login SalesForce using admin credentials
			homeScreen.loginSalesForce(userName, password);
			System.out.println("Step 2:Enter Username");
			ExtentReport.logStat(Status.PASS, "Step 2:Enter Username");
			logger.info("Step 2:Enter Username");
			System.out.println("Step 3:Enter Password");
			ExtentReport.logStat(Status.PASS, "Step 3:Enter Password");
			logger.info("Step 3:Enter Password");
			Thread.sleep(5000);

			// Navigate to AccountingSettings
			
			homeScreen.openSubledgerApp();
			Thread.sleep(3000);
			accountingSubledger.navigateToAccountingSettings();
			ExtentReport.logStat(Status.PASS, "Step 4: navigate to accounting settings menu.");
			logger.info("Step 4: navigate to accounting settings menu.");
			accountingSubledger.VerifyScheduledJobToOnDemand();
			ExtentReport.logStat(Status.PASS, "Step 5: Verify the schedule job to on demand.");
			logger.info("Step 5: Verify the schedule job to on demand.");

			System.out.println("Step 6:End Test: CP_1115_ASL_createJournalEntriesOnDemand");
			ExtentReport.logStat(Status.PASS, "Step 6:End Test: CP_1115_ASL_createJournalEntriesOnDemand");
			logger.info("Step 6:End Test: CP_1115_ASL_createJournalEntriesOnDemand");

		} catch (Exception e) {
			ExtentReport.logStat(Status.FAIL,
					"'CP_1115_ASL_createJournalEntriesOnDemand' test got failed and the error is - "
							+ e);
			Assert.assertEquals(false, true);
		}
	}

}
