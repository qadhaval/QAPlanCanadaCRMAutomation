package org.SalesForceTestAutomation.pageObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.locators.Locators.Create_New_Opportunities_Locators;
import org.SalesForceTestAutomation.locators.Locators.SetThePaymentAsPaid;
import org.SalesForceTestAutomation.utilities.CommonFunctions;
import org.SalesForceTestAutomation.utilities.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class SalesForce_Opportunity extends TestBase implements Create_New_Opportunities_Locators, SetThePaymentAsPaid {
	CommonFunctions commonFunction = new CommonFunctions();
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	// Create new Opportunities Locators
	@FindBy(xpath = ObjOpportunity)
	public WebElement objOpportunity_field;
	
	@FindBy(xpath = Opportunity_NewButton)
	public WebElement opportunityNewButton_field;
	
	@FindBy(xpath = NewOpportunity_NextButton)
	public WebElement newOpportunityNextButton_field;
	
	@FindBy(xpath = Opportunity_Name)
	public WebElement opportunityName_field;
	
	@FindBy(xpath = Opportunity_AccountName)
	public WebElement opportunityAccountName_field;
	
	@FindBy(xpath = Closedate)
	public WebElement closeDate_field;
	
	@FindBy(xpath = Stage)
	public WebElement stage_field;
	
	@FindBy(xpath = Pledged_Stage)
	public WebElement pledgedStage_field;
	
	@FindBy(xpath = Closed_Won)
	public WebElement closedWon_field;
	
	@FindBy(xpath = Declined)
	public WebElement declined_field;
	
	@FindBy(xpath = Closed_Lost)
	public WebElement closedLost_field;
	
	@FindBy(xpath = Amount)
	public WebElement amount_field;
	
	@FindBy(xpath = Opportunity_SaveButton)
	public WebElement opportunitySaveButton_field;
	
	@FindBy(xpath = Opportunity_Stage)
	public boolean opportunityStage_field;

	// Set the payment as paid Locators
	@FindBy(xpath = objPaymentOpportunity)
	public WebElement paymentOpportunity_field;
	
	@FindBy(xpath = objNewPaymentAdd)
	public WebElement objNewPaymentAdd_field;
	
	@FindBy(xpath = objPaymentAmount)
	public WebElement objPaymentAmount_field;
	
	@FindBy(xpath = objPaid)
	public WebElement objPaid_field;

	@FindBy(xpath = objPaid1)
	public WebElement objPaid_field1;
	
	@FindBy(xpath = objPaymentDate)
	public WebElement objPaymentDate_field;
	
	@FindBy(xpath = objScheduleDate)
	public WebElement objScheduleDate_field;
	
	@FindBy(xpath = objPaymentSave)
	public WebElement objPaymentSave_field;

	@FindBy(xpath = objPayments)
	public WebElement paymentHome_field;
	
	@FindBy(xpath = objUsd)
	public WebElement usd_field;
	
	@FindBy(xpath = objNewPaymentButton)
	public WebElement newPaymentButton_field;

	@FindBy(xpath = objPaymentArrowDown)
	public WebElement newPaymentarrowdown_field;

	@FindBy(xpath = paymentRelatedTab)
	public WebElement paymentRelatedTab1;

	@FindBy(xpath = refundNewButton)
	public WebElement refundNewButton1;

	@FindBy(xpath = originalPaymentValidation)
	public WebElement originalPaymentValidation1;
	

	@FindBy(xpath = refundsuccessValidation)
	public WebElement refundsuccessValidation1;

	@FindBy(xpath = Department_Dropdown)
	public WebElement departmentDropdown;
	
	@FindBy(xpath = Product_Dropdown)
	public WebElement productDropdwon;
	
	public SalesForce_Opportunity() {
		PageFactory.initElements(driver, this);
	}

	// Navigate to the Opportunities Field
	public void navigateToOpportunities() throws Exception {

		// Click on the opportunities field on home screen
		executor.executeScript("arguments[0].click();", objOpportunity_field);
		Thread.sleep(3000);
	}

	// Create New Opportunities
	public void createNewOpportunities(String opportunityName, String accountName, String stage, String amount)
			throws InterruptedException {

		String closeDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		// Click on the New Button
		opportunityNewButton_field.click();

		// Click on the Next button
		newOpportunityNextButton_field.click();

		// Enter Opportunity Name
		opportunityName_field.sendKeys(opportunityName);

		// Search Account Name
		opportunityAccountName_field.click();
		opportunityAccountName_field.sendKeys(accountName);
		opportunityAccountName_field.click();
		Thread.sleep(3000);
		opportunityAccountName_field.sendKeys(Keys.ARROW_DOWN);
		opportunityAccountName_field.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// Choose Close Date
		closeDate_field.sendKeys(closeDate);
		Thread.sleep(3000);

		// Select Stage
		// stage_field.sendKeys(stage);
		stage_field.click();

		if (stage.equalsIgnoreCase("Pledged")) {
			pledgedStage_field.click();
		} else if (stage.equalsIgnoreCase("Closed Won")) {
			closedWon_field.click();
		} else if (stage.equalsIgnoreCase("Declined")) {
			declined_field.click();
		} else if (stage.equalsIgnoreCase("Closed Lost")) {
			closedLost_field.click();
		} else {
			System.out.println("Stage Not Found : " + stage);
			ExtentReport.logStat(Status.FAIL, "Stage Not Found : " + stage);
		}

		// Enter Amount
		amount_field.sendKeys(amount);

		// Click on Save button
		opportunitySaveButton_field.click();
		Thread.sleep(3000);
	}
	
	
	// Get value of Department from dropdwon
	
	public String[] getValueofDepartmentDropdwon() throws Exception{
		Thread.sleep(3000);
		commonFunction.scrollToElement(departmentDropdown);
		departmentDropdown.click();
		
		Thread.sleep(10000);
		
		List<WebElement> departmentDropdown = driver.findElements(By.xpath("//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left']/lightning-base-combobox-item/span[2]/span"));
		
		int departmentSize= departmentDropdown.size();
		System.out.println("Department Size  is --- "+ departmentSize);
		String optionsDepartment[] = new String[departmentSize-1];
		
		for (int j = 2; j <= departmentSize; j++) {
			String InnerText = driver.findElement(
					By.xpath("(//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left']/lightning-base-combobox-item["+j+"]/span[2]/span"))
					.getText();
			
			System.out.println("Option in department dropdown no "+j+"is = " +InnerText);
			
			optionsDepartment[j - 1] = InnerText;
		}
		return optionsDepartment;
		
	}
	
	// Get value of product from dropdwon
	public String[] getValueofProductDropdwon()  throws Exception{
		Thread.sleep(3000);
		commonFunction.scrollToElement(departmentDropdown);
		productDropdwon.click();

		Thread.sleep(3000);
		
		List<WebElement> productDropdown = driver.findElements(By.xpath("//lightning-base-combobox-item[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain']"));
		
		int productSize = productDropdown.size();
		System.out.println("Department Size  is --- "+ productSize);
		
		String optionsProduct[] = new String[productSize];
		
		for (int j = 1; j <= productSize; j++) {
			String InnerText = driver.findElement(
					By.xpath("(//lightning-base-combobox-item[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain'])["+j+"]"))
					.getText();
			
			System.out.println("Option in product dropdown no "+j+"is = " +InnerText);
			
			optionsProduct[j - 1] = InnerText;
		}
		return optionsProduct;
		
	}

	// Set the payment as paid
	public void cp_1046_ASL_setThePaymentAsPaid(String objPaymentAmount, String opportunityName) throws Exception {

		String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", paymentHome_field);

		// executor.executeScript("arguments[0].click();",
		// newPaymentButton_field);
		// newPaymentarrowdown_field.click();
		// Thread.sleep(3000);
		// newPaymentarrowdown_field.sendKeys(Keys.ARROW_DOWN);
		// driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		// newPaymentarrowdown_field.sendKeys(Keys.ENTER);
		// driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		Thread.sleep(3000);

		newPaymentButton_field.click();
		Thread.sleep(3000);
		paymentOpportunity_field.click();
		paymentOpportunity_field.sendKeys(opportunityName);
		paymentOpportunity_field.click();
		Thread.sleep(3000);
		paymentOpportunity_field.sendKeys(Keys.ARROW_DOWN);
		paymentOpportunity_field.sendKeys(Keys.ENTER);

		objPaymentAmount_field.sendKeys(objPaymentAmount);
		
		objPaid_field.click();

		objPaymentDate_field.sendKeys(todayDate);

		objScheduleDate_field.sendKeys(todayDate);

		objPaymentSave_field.click();

		Thread.sleep(3000);
		
		navigateToOpportunities();
		String STAGE = objOpportunity_field.getAttribute("Value");
		System.out.println("Check Stage for the opportunity:" + "Stage is" + STAGE);

	}

	public void cp_1110_ASL_setThePaymentAsPaid(String opportunityName, String amountpaid, String amountpaid1,
			String amountpaid2) throws Exception {

		String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", paymentHome_field);

		// executor.executeScript("arguments[0].click();",
		// newPaymentButton_field);
		// newPaymentButton_field.sendKeys(Keys.SPACE);
		// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(3000);
		newPaymentButton_field.click();

		paymentOpportunity_field.click();
		paymentOpportunity_field.sendKeys(opportunityName);
		paymentOpportunity_field.click();
		Thread.sleep(3000);
		paymentOpportunity_field.sendKeys(Keys.ARROW_DOWN);
		paymentOpportunity_field.sendKeys(Keys.ENTER);

		// adding payment value 5000
		objPaymentAmount_field.sendKeys(amountpaid1);
		objPaid_field.click();

		objPaymentDate_field.sendKeys(todayDate);

		objScheduleDate_field.sendKeys(todayDate);

		objPaymentSave_field.click();

		// Adding new payment (2nd payment 10000)
		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", paymentHome_field);
		Thread.sleep(3000);
		newPaymentButton_field.click();

		paymentOpportunity_field.click();
		paymentOpportunity_field.sendKeys(opportunityName);
		paymentOpportunity_field.click();
		Thread.sleep(3000);
		paymentOpportunity_field.sendKeys(Keys.ARROW_DOWN);
		paymentOpportunity_field.sendKeys(Keys.ENTER);
		objPaymentAmount_field.sendKeys(amountpaid2);

		objPaymentDate_field.sendKeys(todayDate);

		objScheduleDate_field.sendKeys(todayDate);

		objPaymentSave_field.click();

		navigateToOpportunities();
		String STAGE = objOpportunity_field.getAttribute("Value");
		System.out.println("Check Stage for the opportunity:" + "Stage is" + STAGE);

	}

	public void cp_1111_ASL_setThePaymentAsPaid(String opportunityName, String amountpaid, String amountpaid1,
			String amountpaid2) throws Exception {

		String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", paymentHome_field);


		// executor.executeScript("arguments[0].click();",
		// newPaymentButton_field);
		// newPaymentButton_field.sendKeys(Keys.SPACE);
		// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(3000);
		newPaymentButton_field.click();

		paymentOpportunity_field.click();
		paymentOpportunity_field.sendKeys(opportunityName);
		paymentOpportunity_field.click();
		Thread.sleep(3000);
		paymentOpportunity_field.sendKeys(Keys.ARROW_DOWN);
		paymentOpportunity_field.sendKeys(Keys.ENTER);

		// adding payment value 5000
		objPaymentAmount_field.sendKeys(amountpaid1);
		objPaid_field.click();

		objPaymentDate_field.sendKeys(todayDate);

		objScheduleDate_field.sendKeys(todayDate);

		objPaymentSave_field.click();

		// Adding new payment (2nd payment 10000)
		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", paymentHome_field);
		Thread.sleep(3000);
		newPaymentButton_field.click();

		paymentOpportunity_field.click();
		paymentOpportunity_field.sendKeys(opportunityName);
		paymentOpportunity_field.click();
		Thread.sleep(3000);
		paymentOpportunity_field.sendKeys(Keys.ARROW_DOWN);
		paymentOpportunity_field.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		objPaymentAmount_field.sendKeys(amountpaid2);
		Thread.sleep(3000);
		objPaid_field1.click();
		Thread.sleep(3000);
		objPaymentDate_field.sendKeys(todayDate);

		objScheduleDate_field.sendKeys(todayDate);

		objPaymentSave_field.click();

		navigateToOpportunities();
		String STAGE = objOpportunity_field.getAttribute("Value");
		System.out.println("Check Stage for the opportunity:" + "Stage is" + STAGE);

	}
	
	
	public String cp_1113_ASL_refundwithPositiveAmount(String opportunityName, String donationamountpaid, String returnamountpaid) throws Exception {

		String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", paymentHome_field);

		Thread.sleep(3000);

		newPaymentButton_field.click();
		paymentOpportunity_field.click();
		paymentOpportunity_field.sendKeys(opportunityName);
		paymentOpportunity_field.click();
		Thread.sleep(3000);
		paymentOpportunity_field.sendKeys(Keys.ARROW_DOWN);
		paymentOpportunity_field.sendKeys(Keys.ENTER);

		objPaymentAmount_field.sendKeys(donationamountpaid);
		
		objPaid_field.click();

		objPaymentDate_field.sendKeys(todayDate);

		objScheduleDate_field.sendKeys(todayDate);

		objPaymentSave_field.click();

		// Try to refund the total amount.
		Thread.sleep(3000);
		paymentRelatedTab1.click();
		refundNewButton1.click();
		paymentOpportunity_field.click();
		paymentOpportunity_field.sendKeys(opportunityName);
		paymentOpportunity_field.click();
		Thread.sleep(3000);
		paymentOpportunity_field.sendKeys(Keys.ARROW_DOWN);
		paymentOpportunity_field.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		objPaymentAmount_field.sendKeys(returnamountpaid);
		
		objPaid_field1.click();

		objPaymentDate_field.sendKeys(todayDate);

		objScheduleDate_field.sendKeys(todayDate);

		objPaymentSave_field.click();
				
		String validationMessage = originalPaymentValidation1.getText();
		
		return validationMessage;
	}

	public String cp_1112_ASL_refundwithaNegativeAmount (String opportunityName, String donationamountpaid, String returnamountpaid) throws Exception {

		String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", paymentHome_field);

		Thread.sleep(3000);

		newPaymentButton_field.click();
		Thread.sleep(3000);
		paymentOpportunity_field.click();
		paymentOpportunity_field.sendKeys(opportunityName);
		paymentOpportunity_field.click();
		Thread.sleep(3000);
		paymentOpportunity_field.sendKeys(Keys.ARROW_DOWN);
		paymentOpportunity_field.sendKeys(Keys.ENTER);

		objPaymentAmount_field.sendKeys(donationamountpaid);
		
		objPaid_field.click();

		objPaymentDate_field.sendKeys(todayDate);

		objScheduleDate_field.sendKeys(todayDate);

		objPaymentSave_field.click();

		// Try to refund the total amount.
		Thread.sleep(3000);
		paymentRelatedTab1.click();
		refundNewButton1.click();
		paymentOpportunity_field.click();
		paymentOpportunity_field.sendKeys(opportunityName);
		paymentOpportunity_field.click();
		Thread.sleep(3000);
		paymentOpportunity_field.sendKeys(Keys.ARROW_DOWN);
		paymentOpportunity_field.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		objPaymentAmount_field.sendKeys(returnamountpaid);
		
		objPaid_field1.click();

		objPaymentDate_field.sendKeys(todayDate);

		objScheduleDate_field.sendKeys(todayDate);

		objPaymentSave_field.click();
		Thread.sleep(5000);
		String count= refundsuccessValidation1.getText();
		return count;
	}
}