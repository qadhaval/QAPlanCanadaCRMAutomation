package org.SalesForceTestAutomation.tests;

import org.testng.annotations.Test;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.pageObject.SalesForce_HomeScreen;
import org.SalesForceTestAutomation.utilities.ExtentReport;
import org.SalesForceTestAutomation.utilities.ReadPropertyFiles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Demo_01_createNewContact extends TestBase {

	ReadPropertyFiles readPro = new ReadPropertyFiles();
	String url = readPro.getSalesForceURL();
	String userName = readPro.getSalesForceUserName();
	String password = readPro.getSalesForcePassword();
	String admin_userName = readPro.getSalesForceAdminUserName();
	String admin_password = readPro.getSalesForceAdminPassword();
	String firstName = readPro.getFirstName();
	String lastName = readPro.getLastName();
	String email = readPro.getNewEmail();
	String phone = readPro.getNewPhone();
	String accountName = readPro.getAccountName();
	String title = readPro.getNewContactTitle();

	@BeforeMethod
	public void beforeMethod() {
		// Start Test
		System.out.println("******* Start Test: CP_01_createNewContact *******");

		// Launch Browser and URL
		openURL(url);
	}

	@Test
	public void cP_01_createNewContact() throws Exception {
		ExtentReport.initialisation("CP_01_createNewContact");
		SalesForce_HomeScreen salesforce = new SalesForce_HomeScreen();

		// Login Salesforce
		salesforce.loginSalesForce(admin_userName, admin_password);

		// Create New Contact
		// Demo Test
//		salesforce.createNewContact(firstName, lastName, email, phone, accountName, title);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("******* End Test: CP_01_createNewContact *******");
		closeBrowser();
	}
}
