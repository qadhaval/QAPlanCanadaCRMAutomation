package org.SalesForceTestAutomation.baseClass;

import java.util.concurrent.TimeUnit;

import org.SalesForceTestAutomation.utilities.ExtentReport;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	// Initialize WebDriver
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeClass

	// Setup Cross Browsing.
	public static void setUp(String browser) {

		// Chrome Browser Driver Initialize
		// Save Salesforce UI cookies to bypass the verification code for login
		if (browser.equalsIgnoreCase("chrome")) {
			// Below line can be commented and it still may work as usual
			String chromeProfilePath = "C:\\Users\\dsathavara\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("user-data-dir=chromeProfilePath");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// FireFox Browser Driver Initialize
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}

		// IE Browser Driver Initialize
		else if (browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} 
		
        // Edge Browser Driver Initialize
        else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Selenium\\msedgedriver.exe");
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        }
        else {
			System.out.println("Driver not found !!!");
		}
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	@BeforeSuite
	public void beforeSuite() {
		// Extent Report Start Up in Before Suite
		ExtentReport.startUp();
	}

	@AfterSuite
	public void afterSuite() {
		// Extent Report End in After Suite
		ExtentReport.endTest();
	}

	// Launch Browser and URL
	public void openURL(String url) {
		driver.get(url);
	}

        // Close Browser
	public void closeBrowser(){
		driver.close();
	}
	
	//define logger class
    public Logger logger = LogManager.getLogger(this.getClass());

}
