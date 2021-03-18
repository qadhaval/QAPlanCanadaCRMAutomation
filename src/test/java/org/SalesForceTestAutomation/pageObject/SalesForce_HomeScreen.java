package org.SalesForceTestAutomation.pageObject;


import org.SalesForceTestAutomation.baseClass.TestBase;
import org.SalesForceTestAutomation.locators.Locators.Create_New_Opportunities_Locators;
import org.SalesForceTestAutomation.locators.Locators.HomeScreen_Locators;
import org.SalesForceTestAutomation.locators.Locators.SetThePaymentAsPaid;
import org.SalesForceTestAutomation.utilities.CommonFunctions;
import org.SalesForceTestAutomation.utilities.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class SalesForce_HomeScreen extends TestBase
		implements HomeScreen_Locators, Create_New_Opportunities_Locators, SetThePaymentAsPaid {
	CommonFunctions commonFunction = new CommonFunctions();
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	
	// SalesForce Login Page Locators
	@FindBy(id = "username")
	public WebElement userName_field;
	@FindBy(id = "password")
	public WebElement password_field;
	@FindBy(id = "Login")
	public WebElement loginButton_field;

	// SalesForce Home Page Locators
	@FindBy(xpath = PlusIcon)
	public WebElement plusIcon_field;
	@FindBy(xpath = NewContact)
	public WebElement newContact_field;
	@FindBy(xpath = Salutation)
	public WebElement salutation_field;
	@FindBy(xpath = Salutation_Mr)
	public WebElement salutationMr_field;
	@FindBy(xpath = Firstname)
	public WebElement firstName_field;
	@FindBy(xpath = Lastname)
	public WebElement lastName_field;
	@FindBy(xpath = Email)
	public WebElement email_field;
	@FindBy(xpath = Phone)
	public WebElement phone_field;
	@FindBy(xpath = AccountName)
	public WebElement accountName_field;
	@FindBy(xpath = Title)
	public WebElement title_field;
	@FindBy(xpath = SaveButton)
	
	//Navigate to Settings
	public WebElement saveButton_field;
	@FindBy(xpath = ProfileIcon)
	public WebElement profileIcon_field;
	@FindBy(xpath = Settings)
	public WebElement settings_field;

	@FindBy(xpath=objApps)
	public WebElement objApp;
	@FindBy(xpath=objNonprofitSuccessPackApp)
	public WebElement objNonprofitSuccessPack;
	@FindBy(xpath = objSubledgerApp)
	public WebElement objSubledger;
	
	public SalesForce_HomeScreen() {
		PageFactory.initElements(driver, this);
		
	}

	// Login Saleforce
	public void loginSalesForce(String userName, String password) {
		// Enter UserName
		//commonFunction.isElementVisibleorNot(userName_field, "User Name");
		userName_field.sendKeys(userName);
	
		// Enter Password
		//commonFunction.isElementVisibleorNot(password_field, "Password");
		password_field.sendKeys(password);

		// Click on Login Button
		//commonFunction.isElementVisibleorNot(loginButton_field, "Login button");
		loginButton_field.click();

		driver.manage().getCookies();
	}
	
	
	public void openNonprofitSuccessPackApp() throws Exception {

		// Click on the opportunities field on home screen
		executor.executeScript("arguments[0].click();", objApp);
		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", objNonprofitSuccessPack);
		Thread.sleep(3000);
		}
	
	public void openSubledgerApp() throws Exception {

		// Click on the opportunities field on home screen
		executor.executeScript("arguments[0].click();", objApp);
		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", objSubledger);
		Thread.sleep(3000);
		}
	
	// Create new Contact

	public void createNewContact(String firstName, String lastName, String email, String phone, String accountName,
			String title) throws Exception {
		// Click on plus icon
		plusIcon_field.click();

		// Click on New Contact
		newContact_field.click();

		// Select Salutation
		salutation_field.click();
		Thread.sleep(2000);
		salutationMr_field.click();
		Thread.sleep(2000);

		// Enter First Name
		firstName_field.sendKeys(firstName);

		// Enter Last Name
		lastName_field.sendKeys(lastName);

		// Enter Email Address
		email_field.sendKeys(email);

		// Enter Phone Number
		phone_field.sendKeys(phone);

		// Search Account Name
		accountName_field.sendKeys(accountName);
		Thread.sleep(2000);
		accountName_field.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		accountName_field.sendKeys(Keys.ENTER);

		// Enter Title
		title_field.sendKeys(title);

		// Click on Save button
		saveButton_field.click();
		Thread.sleep(5000);

		System.out.println("Contact Created Successfully !!!");
		ExtentReport.logStat(Status.PASS, "New contact Created Successfully !!!");
	}

	// Navigate To Settings
	public void navigateToSettings(String text) throws Exception {
		profileIcon_field.click();
		Thread.sleep(2000);

		settings_field.click();
		Thread.sleep(6000);
		commonFunction.isElementPresentOrNot(By.xpath("//h1[contains(text(),'" + text + "')]"), text);

		// Navigate To Back page
		commonFunction.navigateToBack();
		Thread.sleep(3000);

		// Navigate To Forward Page
		commonFunction.navigateToForward();
		Thread.sleep(6000);
	}	
}
