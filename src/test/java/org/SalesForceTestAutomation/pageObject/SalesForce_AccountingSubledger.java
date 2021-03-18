package org.SalesForceTestAutomation.pageObject;


import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.locators.Locators.Create_New_Opportunities_Locators;
import org.SalesForceTestAutomation.locators.Locators.SetThePaymentAsPaid;
import org.SalesForceTestAutomation.locators.Locators.LedgerEntries_Locators;
import org.SalesForceTestAutomation.utilities.CommonFunctions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.SalesForceTestAutomation.locators.Locators.AccountingSetting_Locators;
import org.SalesForceTestAutomation.locators.Locators.HomeScreen_Locators;

public class SalesForce_AccountingSubledger extends TestBase implements HomeScreen_Locators, Create_New_Opportunities_Locators, SetThePaymentAsPaid, AccountingSetting_Locators, LedgerEntries_Locators{

	CommonFunctions commonFunction = new CommonFunctions();
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	@FindBy(xpath = ObjAccountinfSettingsApp)
	public WebElement objAccountingSettings;
	@FindBy(xpath = objRunAccountingSchedulingJob)
	public WebElement objRunAccountingSchedulingJob1;
	@FindBy(xpath = objSuccessMessage)
	public WebElement objSuccessMessage1;
	@FindBy(xpath = objLedgerEntries)
	public WebElement objLedgerEntries1;
	
	public SalesForce_AccountingSubledger() {
		PageFactory.initElements(driver, this);
	}
	
	
	// Navigate to the Opportunities Field
		public void navigateToAccountingSettings() throws Exception {
			executor.executeScript("arguments[0].click();", objAccountingSettings);
			Thread.sleep(3000);
			}

		public void VerifyScheduledJobToOnDemand() throws Exception {
			Thread.sleep(3000);
			driver.switchTo().frame(0);
//			driver.findElement(By.xpath("//*[@id=\"brandBand_2\"]/div/div/div[2]/div/force-aloha-page/div/iframe")).click();
//			commonFunction.scrollToElement("//*[@id=\"j_id0:accountingSettings:j_id64\"]");
			objRunAccountingSchedulingJob1.click();
			Thread.sleep(5000);
			String msg = objSuccessMessage1.getText();
			System.out.println(msg);
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			executor.executeScript("arguments[0].click();", objLedgerEntries1);
			Thread.sleep(5000);
		}
}
