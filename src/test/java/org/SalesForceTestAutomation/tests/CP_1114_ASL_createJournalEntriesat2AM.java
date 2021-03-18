package org.SalesForceTestAutomation.tests;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.pageObject.SalesForce_AccountingSubledger;
import org.SalesForceTestAutomation.pageObject.SalesForce_HomeScreen;
import org.SalesForceTestAutomation.pageObject.SalesForce_Setup;
import org.SalesForceTestAutomation.utilities.ExtentReport;
import org.SalesForceTestAutomation.utilities.ReadPropertyFiles;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

public class CP_1114_ASL_createJournalEntriesat2AM extends TestBase {
	ReadPropertyFiles readPro = new ReadPropertyFiles();
	String url = readPro.getSalesForceURL();
	String SetupUrl = readPro.getSalesForceSetupURL();
	String userName = readPro.getSalesForceAdminUserName();
	String password = readPro.getSalesForceAdminPassword();

	static SalesForce_HomeScreen homeScreen;
	static SalesForce_Setup setupScreen;
	static SalesForce_AccountingSubledger accountingSubledger;
	
	@BeforeMethod
	public void initPages() {
		homeScreen = PageFactory.initElements(driver, SalesForce_HomeScreen.class);
		// SalesForce_HomeScreen homeScreen = new SalesForce_HomeScreen();

		setupScreen = PageFactory.initElements(driver, SalesForce_Setup.class);
		// SalesForce_Opportunity opportunity = new SalesForce_Opportunity();
		
		accountingSubledger = PageFactory.initElements(driver, SalesForce_AccountingSubledger.class);
		// SalesForce_Opportunity opportunity = new SalesForce_Opportunity();
	}

	@Test(priority = 1)
	public void SF_Admin_Login() throws Exception {

		try {
			// Start Test
			System.out.println("Step 1:Start Test: CP_1114_ASL_createJournalEntriesat2AM");
			logger.info("Step 1:Start Test: CP_1114_ASL_createJournalEntriesat2AM");
			ExtentReport.initialisation("CP_1114_ASL_createJournalEntriesat2AM");
			
			// Launch Browser and URL
			openURL(url);
			ExtentReport.logStat(Status.PASS, "Step 1: Url open in browser.");
			
			// Login SalesForce using admin credentials
			homeScreen.loginSalesForce(userName, password);
			System.out.println("Step 2:Enter Username");
			ExtentReport.logStat(Status.PASS, "Step 2:Enter Username");
			logger.info("Step 2:Enter Username");
			System.out.println("Step 3:Enter Password");
			ExtentReport.logStat(Status.PASS, "Step 3:Enter Password.");
			logger.info("Step 3:Enter Password");
			Thread.sleep(10000);

			openURL(SetupUrl);
			logger.info("Step 4: Open Setup page");
			ExtentReport.logStat(Status.PASS, "Step 4: Open Setup page.");
			
			// Navigate to AccountingSettings
			setupScreen.navigateToApexJob();
			logger.info("Step 5: Open Apex job page");
			ExtentReport.logStat(Status.PASS, "Step 5: Open Apex job page.");
			
			setupScreen.GetDataFromTableRow(36, 6);
			ExtentReport.logStat(Status.PASS, "Step 6: Get all data of schedule record.");
			logger.info("Step 6: Get all data of schedule record.");

			System.out.println("Step 7:End Test: CP_1114_ASL_createJournalEntriesat2AM");
			logger.info("Step 7:Start Test: CP_1114_ASL_createJournalEntriesat2AM");
		
		} catch (Exception e) {
			ExtentReport.logStat(Status.FAIL,
					"'CP_1114_ASL_createJournalEntriesat2AM' test got failed and the error is - " + e);
			Assert.assertEquals(false, true);
		}
	}

}
