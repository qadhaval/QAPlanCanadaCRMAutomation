package org.SalesForceTestAutomation.utilities;

import java.util.ArrayList;

import org.SalesForceTestAutomation.baseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class CommonFunctions extends TestBase {

	Actions action = new Actions(driver);

	// Get Current URL
	public void getCurrentURL() {
		driver.getCurrentUrl();
	}

/*	// Switch to New Frame
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
*/
	// Get Title
	public void getTitle() {
		driver.getTitle();
	}

	// Navigate to Forward
	public void navigateToForward() {
		driver.navigate().forward();
	}

	// Navigate to Back
	public void navigateToBack() {
		driver.navigate().back();
	}

	// Scroll Down
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}

	// Scroll Up
	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
	}

/*	// Drag And Drop
	public void dragAndDrop(WebElement sourceLocator, WebElement destinationLocator) {
		WebElement sourceElement = driver.findElement((By) sourceLocator);
		WebElement destinationElement = driver.findElement((By) destinationLocator);
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, destinationElement).build().perform();
	}*/

	// Verify that Element is present or Not,
	public boolean isElementPresentOrNot(By locatorKey, String msg) { //By locatorKey ,WebElement elmt
		try {
			driver.findElement(locatorKey);
			System.out.println("Element " + msg + " is present on the screen");
			ExtentReport.logStat(Status.INFO, "Element " + msg + " is present on the screen");
			System.out.println("PASSED :Element " + msg + " is present on the screen");
			Assert.assertTrue(true, "Element " + msg + " is present on the screen");
			return true;
		} catch (Exception e) {
			System.out.println("Element " + msg + " is not present on the screen");
			ExtentReport.logStat(Status.INFO, "Element " + msg + " is not present on the screen");
			System.out.println("FAILED :Element " + msg + " is not present on the screen");
			Assert.assertTrue(false, "Element " + msg + " is not present on the screen");
			return false;
		}
	}


	public boolean isElementVisibleorNot(WebElement elmnt, String msg) { //By locatorKey ,WebElement elmnt
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(elmnt));
			elmnt.isDisplayed();
		System.out.println("Element " + msg + " is present on the screen");
		Assert.assertTrue(true, "Element " + msg + " is present on the screen");
			return true;
		} catch (Exception e) {
			System.out.println("Element " + msg + " is not present on the screen");
			Assert.assertTrue(false, "Element " + msg + " is not present on the screen");
			return false;
		}
	}
	
	// User defined method to check the alert is present or not
	public boolean isAlertPresent() throws NoAlertPresentException {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	// Clear Cookie
	public void clearCookie() {
		driver.manage().deleteAllCookies();
	}

	// Navigate To New Tab
	public void navigateToNewTab() {
		((JavascriptExecutor) driver).executeScript("window.open();");
	}
	
	//Anteneh methods added below-----------------------------
	
	//method to move to bottom of page
	public static void scrollToBottom()  
	{
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	
	//method to move to top of page
	public static void scrollToTop()  
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");	
	}
	
	//method to move to specific element
	public void scrollToElement(WebElement element)  
	{
		
//		WebElement element = driver.findElement(By.xpath(xPathLocator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);		
	}
	
	//method to switch between tab numbers 0,1...
	public void goTab(int tabNumber)
	{
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(tabNumber));
	}
	
	//method to open new tab
	public void openNewTab() {
		((JavascriptExecutor)driver).executeScript("window.open();");
	}
	
}
