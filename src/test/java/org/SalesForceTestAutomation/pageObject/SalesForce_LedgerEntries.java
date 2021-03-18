package org.SalesForceTestAutomation.pageObject;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.locators.Locators.AccountingSetting_Locators;
import org.SalesForceTestAutomation.locators.Locators.Create_New_Opportunities_Locators;
import org.SalesForceTestAutomation.locators.Locators.SetThePaymentAsPaid;
import org.SalesForceTestAutomation.locators.Locators.LedgerEntries_Locators;
import org.SalesForceTestAutomation.utilities.CommonFunctions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesForce_LedgerEntries extends TestBase
		implements Create_New_Opportunities_Locators, SetThePaymentAsPaid, AccountingSetting_Locators, LedgerEntries_Locators{

	CommonFunctions commonFunction = new CommonFunctions();
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	@FindBy(xpath = objLedgerEntries)
	public WebElement objLedgerEntries1;
	
	public SalesForce_LedgerEntries() {
		PageFactory.initElements(driver, this);
	}

}
