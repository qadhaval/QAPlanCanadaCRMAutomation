package org.SalesForceTestAutomation.pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.locators.Locators.AccountingSetting_Locators;
import org.SalesForceTestAutomation.locators.Locators.Setup_Locators;
import org.SalesForceTestAutomation.locators.Locators.Create_New_Opportunities_Locators;
import org.SalesForceTestAutomation.locators.Locators.SetThePaymentAsPaid;
import org.SalesForceTestAutomation.utilities.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesForce_Setup extends TestBase
		implements Create_New_Opportunities_Locators, SetThePaymentAsPaid, AccountingSetting_Locators, Setup_Locators {

	CommonFunctions commonFunction = new CommonFunctions();
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	@FindBy(xpath = objQuickSearch)
	public WebElement objQuickSearch1;
	@FindBy(xpath = objApexJob)
	public WebElement objApexJob1;
	@FindBy(xpath = onjApexjobTitle)
	public WebElement onjApexjobTitle1;

	public SalesForce_Setup() {
		PageFactory.initElements(driver, this);
	}

	// Navigate to the Apex Job
	public void navigateToApexJob() throws Exception {
		
		objQuickSearch1.sendKeys("Apex Job");
		Thread.sleep(3000);
		objApexJob1.click();
		Thread.sleep(3000);
		String title = onjApexjobTitle1.getText();
		System.out.println(title);
	}
	
	// Get the all value of row.
	public String[] GetDataFromTableRow(int TotalRow, int Totalcol) throws Exception {

		Thread.sleep(3000);
		driver.switchTo().frame(0);	
		
			
		// instantiation
		
		List<WebElement> table = driver.findElements(
				By.xpath("//*[@id='thePage:theTemplate:panelGrid']/tbody/tr/td/div[4]/div/div[2]/table/tbody/tr[2]/td"));
		int col = table.size();
		System.out.println("Col sizew is = " +col);
		int i;	
		
		for (i = 2; i <= TotalRow; i++) {

			
			String InnerText = driver.findElement(
					By.xpath("//*[@id='thePage:theTemplate:panelGrid']/tbody/tr/td/div[4]/div/div[2]/table/tbody/tr["
							+ i + "]/td[6]"))
					.getText();

			if (InnerText.equalsIgnoreCase("1")) {

				break;
			}
			System.out.println("Data not matched & row is = " + i + "");
		}
		String ApexRecordDetails[] = new String[col];// declaration and
		int validDataRow = i;
		for (int j = 1; j <= col; j++) {
			String InnerTextrow = driver.findElement(
					By.xpath("//*[@id='thePage:theTemplate:panelGrid']/tbody/tr/td/div[4]/div/div[2]/table/tbody/tr["
							+ validDataRow + "]/td["+j+"]"))
					.getText();
			System.out.println("Data of the cel is = " +InnerTextrow);
			
			ApexRecordDetails[j - 1] = InnerTextrow;
		}

		driver.switchTo().defaultContent();
		return ApexRecordDetails;
	}
}
