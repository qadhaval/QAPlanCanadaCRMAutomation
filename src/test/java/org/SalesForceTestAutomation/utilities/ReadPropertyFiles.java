package org.SalesForceTestAutomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFiles {

	Properties configProperty;
	Properties dataProperty;

	public ReadPropertyFiles() {
		File src = new File("./Configuration/config.properties");
		File src1 = new File("./Configuration/testdata.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			configProperty = new Properties();
			configProperty.load(fis);

			FileInputStream fis1 = new FileInputStream(src1);
			dataProperty = new Properties();
			dataProperty.load(fis1);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}

	// Get Extent Report Path from Property File
	public String getExtentReportPath() {
		String extentReportPath = configProperty.getProperty("EXTENT_REPORT_PATH");
		return extentReportPath;
	}

	// Get Excel Test Data File Path from Property File
	public String getExcelSheetPath() {
		String excelSheetPath = configProperty.getProperty("EXCEL_TEST_DATA");
		return excelSheetPath;
	}

	// Get Testfundraise URL
	public String getTestfundraiseURL() {
		String testfundraiseURL = dataProperty.getProperty("PLAN_CANADA_TESTFUNDRAISE_URL");
		return testfundraiseURL;
	}

	// Get Excel Sheet One
	public String getExcelSheetOne() {
		String excelSheetOne = dataProperty.getProperty("SHEET_ONE");
		return excelSheetOne;
	}

	// Get Excel Sheet Two
	public String getExcelSheetTwo() {
		String excelSheetTwo = dataProperty.getProperty("SHEET_TWO");
		return excelSheetTwo;
	}

	// Get Excel Sheet Three
	public String getExcelSheetThree() {
		String excelSheetThree = dataProperty.getProperty("SHEET_THREE");
		return excelSheetThree;
	}

	// Salesforce Get Data
	public String getSalesForceURL() {
		String salesForceURL = dataProperty.getProperty("SALESFORCE_URL");
		return salesForceURL;
	}
	
	// Salesforce Get Force Setup Url
		public String getSalesForceSetupURL() {
			String salesForceForceSetupURL = dataProperty.getProperty("SF_SETUP_URL");
			return salesForceForceSetupURL;
		}

	// Get SalesForce UserName
	public String getSalesForceUserName() {
		String salesForceUsername = dataProperty.getProperty("SALESFORCE_USERNAME");
		return salesForceUsername;
	}

	// Get SalesForce Admin UserName
	public String getSalesForceAdminUserName() {
		String salesForceAdminUsername = dataProperty.getProperty("SALESFORCE_ADMIN_USERNAME");
		return salesForceAdminUsername;
	}
	
	// Get Salesforce Admin Password
	public String getSalesForceAdminPassword() {
		String salesForceAdminPassword = dataProperty.getProperty("SALEFORCE_ADMIN_PASSWORD");
		return salesForceAdminPassword;
	}

	// Get Salesforce Password
	public String getSalesForcePassword() {
		String salesForcePassword = dataProperty.getProperty("SALEFORCE_PASSWORD");
		return salesForcePassword;
	}

	// Get New Contact First Name
	public String getFirstName() {
		String firstName = dataProperty.getProperty("FIRST_NAME");
		return firstName;
	}

	// Get New Contact Last Name
	public String getLastName() {
		String lastName = dataProperty.getProperty("LAST_NAME");
		return lastName;
	}

	// Get New Contact Email
	public String getNewEmail() {
		String newEmail = dataProperty.getProperty("EMAIL");
		return newEmail;
	}

	// Get New Phone
	public String getNewPhone() {
		String newPhone = dataProperty.getProperty("PHONE");
		return newPhone;
	}

	// Get Account Name
	public String getAccountName() {
		String accountName = dataProperty.getProperty("ACCOUNT_NAME");
		return accountName;
	}

	// Get New Contact Title
	public String getNewContactTitle() {
		String newContactTitle = dataProperty.getProperty("TITLE");
		return newContactTitle;
	}

	// Get SalesForce UserName
	public String get_SF_url() {
		String getSalesforceUrl = dataProperty.getProperty("SF_URL");
		return getSalesforceUrl;
	}

	public String get_TableLabel() {
		String getTableLabel = dataProperty.getProperty("SF_Label");
		return getTableLabel;
	}

	public String get_TablePlural() {
		String getTablePlural = dataProperty.getProperty("SF_Plural");
		return getTablePlural;
	}

	public String get_TableDesc() {
		String getTableDesc = dataProperty.getProperty("SF_Desc");
		return getTableDesc;
	}

	// Create new opportunities Get Data
	// Get Opportunity Name
	public String getOpportunityName() {
		String opportunityName = dataProperty.getProperty("OPPORTUNITY_NAME");
		return opportunityName;
	}

	// Get Account Name
	public String getOpportunityAccountName() {
		String opportunityAccountName = dataProperty.getProperty("ACCOUNT_NAME");
		return opportunityAccountName;
	}

	// Get Opportunity Amount
	public String getOpportunityAmount() {
		String opportunityAmount = dataProperty.getProperty("AMOUNT");
		return opportunityAmount;
	}

	// Get Stage
	public String getStage() {
		String stage = dataProperty.getProperty("STAGE");
		return stage;
	}
	
	// Set Payment As Paid
	public String getOpportunityAmountAdd() {
		String OpportunityAmountAdd = dataProperty.getProperty("AMOUNT_PAYMENT");
		return OpportunityAmountAdd;
	}
	
	public String getOpportunityAmount1Add() {
		String OpportunityAmount1Add = dataProperty.getProperty("AMOUNT_PAYMENT1");
		return OpportunityAmount1Add;
	}
	
	public String getOpportunityAmount2Add() {
		String OpportunityAmount2Add = dataProperty.getProperty("AMOUNT_PAYMENT2");
		return OpportunityAmount2Add;
	}
	
	public String getReturnAmountPayment() {
		String ReturnAmountPayment = dataProperty.getProperty("RETURN_AMOUNT_PAYMENT");
		return ReturnAmountPayment;
	}
	
	public String getReturnAmountPayment1() {
		String ReturnAmountPayment1 = dataProperty.getProperty("RETURN_AMOUNT_PAYMENT1");
		return ReturnAmountPayment1;
	}
	
	
	
	// Get the locators of set up screen
	public String getQuickSearch() {
		String QuickSearch_dropdown = dataProperty.getProperty("objQuickSearch");
		return QuickSearch_dropdown ;
	}
	
	public String getApexJob() {
		String ApexJob_dropdwon_option= dataProperty.getProperty("objApexJob");
		return ApexJob_dropdwon_option;
	}
	
	public String getApexJobTitle() {
		String ApexJob_Title= dataProperty.getProperty("onjApexjobTitle");
		return ApexJob_Title;
	}
	
	// Get the locators of set up screen
		public String getLedgerEntries() {
			String objLedgerEntries_dropdown = dataProperty.getProperty("objLedgerEntries");
			return objLedgerEntries_dropdown ;
		}
	
		
		//-----------------Anteneh METHODS BELOW, BEFORE ACTUAL SF TESTCASES-----------------
		//Salesforce Dev env. below----------------------------------------------------------------------------------
		//Get billing card number CVV for TributeSiteURL donation
/*		public String get_SF_url()
		{
			String sfURL  = dataProperty.getProperty("SF_URL");
			return sfURL;		
		}*/
		
		public String get_SF_NewObj_url()
		{
			String sfURL_newObj  = dataProperty.getProperty("SF_URL_NewObject");
			return sfURL_newObj;	
		}
			
		public String get_SFusername()
		{
			String sfUsername = dataProperty.getProperty("SF_USERNAME");
			return sfUsername;
		}
		
		public String get_SFpassword()
		{
			String sfPassword = dataProperty.getProperty("SF_PW");
			return sfPassword;
		}
		
		
		//SQL query reader-----------------------------------
		public String get_SQL_query()
		{
			String sql_query = dataProperty.getProperty("SQL_query");
			return sql_query;
		}
		
		//Jira URL reader------------------------------------------
		public String get_JiraTestPage()
		{
			String jira_TestPage_URL = dataProperty.getProperty("Jira_TestCasePage_BaseURL");
			return jira_TestPage_URL;
		}
}
