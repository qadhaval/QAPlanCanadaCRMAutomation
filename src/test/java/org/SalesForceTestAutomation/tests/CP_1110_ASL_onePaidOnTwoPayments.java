package org.SalesForceTestAutomation.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.pageObject.SalesForce_Opportunity;
import org.SalesForceTestAutomation.pageObject.SalesForce_HomeScreen;
import org.SalesForceTestAutomation.utilities.ExtentReport;
import org.SalesForceTestAutomation.utilities.ReadPropertyFiles;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CP_1110_ASL_onePaidOnTwoPayments extends TestBase {

	ReadPropertyFiles readPro = new ReadPropertyFiles();
	String url = readPro.getSalesForceURL();
	String userName = readPro.getSalesForceUserName();
	String password = readPro.getSalesForcePassword();
	String opportunityName = readPro.getOpportunityName();
	String accountName = readPro.getAccountName();
	String stage = readPro.getStage();
	String amount = readPro.getOpportunityAmount();
	String amountpaid = readPro.getOpportunityAmount();
	String amountpaid1 = readPro.getOpportunityAmount1Add();
	String amountpaid2 = readPro.getOpportunityAmount2Add();

	
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
	public void salesForce_HomeScreen() throws Exception {
		try {

			// Start Test
			System.out.println("Start Test:CP_1110_ASL_onePaidOnTwoPayments");
			logger.info("Start Test:CP_1110_ASL_onePaidOnTwoPayments");
			ExtentReport.initialisation("CP_1110_ASL_onePaidOnTwoPayments");

			// Launch Browser and URL
			openURL(url);
			
			
			ExtentReport.logStat(Status.PASS, "Step 1: Url open in browser.");

			// Login SalesForce
//			homeScreen.loginSalesForce(userName, password);
			
//			commonFunction.isElementVisibleorNot(userName_field, "User Name");
//			userName_field.sendKeys(userName);
//			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			homeScreen.userName_field.sendKeys(userName);
			// Enter Password
//			commonFunction.isElementVisibleorNot(password_field, "Password");
//			password_field.sendKeys(password);
//			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			homeScreen.password_field.sendKeys(password);
			// Click on Login Button
//			commonFunction.isElementVisibleorNot(loginButton_field, "Login button");
//			loginButton_field.click();
//			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

			homeScreen.loginButton_field.click();
			
			System.out.println("Step 2:Enter Username");
			ExtentReport.logStat(Status.PASS, "Step 2:Enter Username");
			logger.info("Step 2:Enter Username");
			System.out.println("Step 3:Enter Password");
			ExtentReport.logStat(Status.PASS, "Step 3:Enter Password");
			logger.info("Step 3:Enter Password");

			// Open Non Profit Success Pack App.
			homeScreen.openNonprofitSuccessPackApp();

			// Navigate to the Opportunities Field.
			opportunity.navigateToOpportunities();

			// Create new Opportunities
			opportunity.createNewOpportunities(opportunityName, accountName, stage, amount);
			System.out.println("Step 4:Create new opportunity");
			ExtentReport.logStat(Status.PASS, "Step 4:Create new opportunity");
			logger.info("Step 4:Create new opportunity");

			// Set the payment as paid with two payments
			opportunity.cp_1110_ASL_setThePaymentAsPaid(opportunityName, amountpaid, amountpaid1, amountpaid2);
			System.out.println("Step 5:Set the payment as paid");
			ExtentReport.logStat(Status.PASS, "Step 5:Set the payment as paid");
			logger.info("Step 5:Set the payment as paid");

			System.out.println("Step 6:End Test: CP_1110_ASL_onePaidOnTwoPayments");
			ExtentReport.logStat(Status.PASS, "Step 6:End Test: CP_1110_ASL_onePaidOnTwoPayments");
			logger.info("Step 6:End Test: CP_1110_ASL_onePaidOnTwoPayments");
		} catch (Exception e) {
			ExtentReport.logStat(Status.FAIL, "'CP_1110_ASL_onePaidOnTwoPayments' test got failed and the error is - " + e);
			Assert.assertEquals(false, true);

		}
	}
	}
