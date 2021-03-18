package org.SalesForceTestAutomation.locators;

public interface Locators {
	
	// -----------------------  Dhaval  --------------------------

	// SalesForce Home Screen Locators
	public interface HomeScreen_Locators {
		String PlusIcon = "//a[starts-with(@class, 'globalCreateTrigger')]/div/lightning-icon";
		String Salutation = "//a[contains(text(),'--None--')]";
		String Salutation_Mr = "/html/body/div[10]/div/ul/li[2]/a";
		String Firstname = "/html/body/div[4]/div[1]/section/div[2]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div[1]/section/div/section/div/div/div/div/div/div[1]/div/div/div/fieldset/div/div[2]/input";
		String Lastname = "/html/body/div[4]/div[1]/section/div[2]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div[1]/section/div/section/div/div/div/div/div/div[1]/div/div/div/fieldset/div/div[4]/input";
		String Email = "/html/body/div[4]/div[1]/section/div[2]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div[1]/section/div/section/div/div/div/div/div/div[2]/div/div/div/div/input";
		String Phone = "/html/body/div[4]/div[1]/section/div[2]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div[1]/section/div/section/div/div/div/div/div/div[3]/div/div/div/div/input";
		String AccountName = "/html/body/div[4]/div[1]/section/div[2]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div[1]/section/div/section/div/div/div/div/div/div[4]/div/div/div/div/div/div/div[1]/div/input";
		String Title = "/html/body/div[4]/div[1]/section/div[2]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div[1]/section/div/section/div/div/div/div/div/div[5]/div/div/div/div/input";
		String NewContact = "//*[@id='oneHeader']/div[3]/span/div[2]/ul/li[3]/div/div/div[2]/div/ul/li[6]/a/span[2]";
		String SaveButton = "/html/body/div[4]/div[1]/section/div[2]/div[1]/div[5]/div/div/div/div/div/div[2]/div/div[2]/div[2]/button/span";

		// Salesforce_NavigateToContact.java
		String ContactModule = "/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[4]/a";
		String ProfileIcon = "//*[@id='oneHeader']/div[3]/span/div[2]/ul/li[8]/span/button/div/span[1]/div/span";
		String Settings = "//a[contains(text(),'Settings')]";

		// 
		String objApps = "//button[@class = \"slds-button slds-show\"]";
		String objNonprofitSuccessPackApp= "//p[@class='slds-truncate'][text()='Nonprofit Success Pack']";
		String objSubledgerApp = "//p[@class = \"slds-truncate\"][text() = \"Subledger\"]";
		String ObjAccountinfSettingsApp = "/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[7]/a/span";

	}

	// Create new opportunities Locators
	public interface Create_New_Opportunities_Locators {
		String ObjOpportunity = "/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[5]/a";
		String Opportunity_NewButton = "//*[@id='brandBand_1']/div/div/div/div/div[1]/div[1]/div[2]/ul/li/a";
		String NewOpportunity_NextButton = "/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/button[2]";
		String Opportunity_Name = "//input[@type = 'text'][@name  = 'Name'][@class = 'slds-input']";
		// String Opportunity_AccountName = "//input[@placeholder = 'Search
		// Accounts...'][@id='input-364']";
		String Opportunity_AccountName = "//input[@placeholder = 'Search Accounts...']";
		String SearchIcon = "//*[@id=\"sectionContent-118\"]/div/slot/force-record-layout-row[2]/slot/force-record-layout-item[1]/div/span/slot/slot/force-record-layout-lookup/lightning-lookup/lightning-lookup-desktop/lightning-grouped-combobox/div[1]/div/lightning-base-combobox/div/div[1]/div/lightning-icon/lightning-primitive-icon/svg";
		String Closedate = "//*[@name=\"CloseDate\"]";
		String Stage = "//input[@id=\"input-146\"]";
		String Pledged_Stage = "//*[@id=\"input-146-1-146\"]";
		String Closed_Won = "//*[@id=\"input-146-2-146\"]";
		String Declined = "//*[@id=\"input-146-3-146\"]";
		String Closed_Lost = "//*[@id=\"input-146-4-146\"]";
		String Amount = "//*[@name=\"Amount\"]";
		String Opportunity_SaveButton = "//button[@name='SaveEdit']";
		String Opportunity_Stage = "//*[@id=\"brandBand_1\"]/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[6]/span";
		String Department_Dropdown = "(//input[@type='text'][@class='slds-input slds-combobox__input'])[11]";
		String Product_Dropdown = "(//input[@type='text'][@class='slds-input slds-combobox__input'])[12]";
	}

	// Set the payment as paid
	public interface SetThePaymentAsPaid {

		String objPayments = "/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[6]/a/span";
		String objNewPaymentButton = "//*[@id=\"brandBand_1\"]/div/div/div/div/div[1]/div[1]/div[2]/ul/li/a/div";
		String objPaymentArrowDown = "/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[6]/one-app-nav-bar-item-dropdown/div";

		// String objPaymentOpportunity = "//*[@id='input-1020']";
		String objPaymentOpportunity = "//input[@class = 'slds-input slds-combobox__input'][@type = 'text'][@placeholder= 'Search Opportunities...']";

		String objUsd = "//*[@id='checkbox-121']";
		String objNewPaymentAdd = "//*[@id='brandBand_1']/div/div/div/div/div[1]/div[1]/div[2]/ul/li/a/div";
		// String objPaymentAmount = "//*[@id='input-902']";
		String objPaymentAmount = "//input[@name='npe01__Payment_Amount__c'][@class = 'slds-input']";
		String objPaid = "//input[@type= 'checkbox'][@name='npe01__Paid__c']";
		String objPaid1 = "(//input[@type= 'checkbox'][@name='npe01__Paid__c'])[2]";
		String objPaymentDate = "//input[@type= 'text'][@name='npe01__Payment_Date__c'][@class='slds-input']";
		String objScheduleDate = "//input[@type= 'text'][@name='npe01__Scheduled_Date__c'][@class='slds-input']";
		String objPaymentSave = "//button[@class = 'slds-button slds-button_brand']";

		String arrowDown = "//*[@id=\"585:0\"]/div/div/table/tbody/tr[1]/td[7]/span/div";
		String editLink = "//*[@id=\"1163:0\"]/div/ul/li/a/div";
		String saveEditedPayment = "//*[@id=\"content_1281:0\"]/div/div/div/records-lwc-detail-panel/records-base-record-form/div/div/div/force-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-headless-action-render/slot[1]/slot/lightning-button/button";
		String getCurrentOpportunityStatus = "//*[@id=\"585:0\"]/div/div/table/tbody/tr[1]/td[6]/span/span";
		
		String paymentRelatedTab = "(//a[@class = 'slds-tabs_default__link'][@id='relatedListsTab__item'][text()='Related'])[2]";
		String refundNewButton = "(//button[@name='New'][@type='button'][@class='slds-button slds-button_neutral'][text()='New'])[1]";
		String originalPaymentValidation="//div[@class='slds-form-element__help']";
		String refundsuccessValidation = "(//span[@class='lds-shrink-none slds-m-right--xx-small'])[1]";
		

	}
	
	public interface AccountingSetting_Locators{
		//		String objRunAccountingSchedulingJob="(//input[@class='btn'][@type='submit'])[2]";
		String objRunAccountingSchedulingJob="//*[@id=\"j_id0:accountingSettings:j_id64\"]";
		String objSuccessMessage="(//span[@class='slds-form-element__help slds-text-color_success slds-m-bottom_medium'])[1]";
	}
	

	public interface LedgerEntries_Locators{
		String objLedgerEntries="//span[@class='slds-truncate'][text()='Ledger Entries']";
	}
	
	public interface Setup_Locators{
		String objQuickSearch="//input[@class='filter-box input'][@type='search']";
		String objApexJob="//div[@class='slds-tree__item'][@title='Apex Jobs']";
		String onjApexjobTitle ="//span[@class='breadcrumbDetail uiOutputText'][text()='Apex Jobs']";
	}
	
	// -----------------------  Anteneh --------------------------
	
		//locators for JIRA
			public interface Jira_locators {
				String statusMenuDropdown = "//*[@id=\"jira-frontend\"]/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/div/div[2]/div[1]/div/div[1]";
				String statusMenuLink = "(//span[contains(@class,'sc-htpNat dcTkON')])[22]";
				String assigneeLink = "//div[@data-test-id='issue.views.field.user.assignee']//div//div[@class='ReadViewContentWrapper-xymwx5-0 kLiHRY']";
				String reporterLink = "//div[@data-test-id='issue.views.field.user.reporter']//div//div[@class='ReadViewContentWrapper-xymwx5-0 kLiHRY']";
				String workinProgressLink =	"/html//div[@id='jira-frontend']/div[1]/div[@class='css-kjt1ym']/div[@class='css-ld3atn']/div[2]/div[@class='css-1f63klf']/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div[1]//div[@class='css-nipym0']/div[1]/div[2]/div/div/div/span[1]";
				String workinProgressLink2 = "//span[normalize-space()='Work in Progress']";	
				String passedLink = "//span[normalize-space()='Passed']";
				String failedLink = "//span[normalize-space()='Failed']";
				String blockedLink = "//span[normalize-space()='Blocked']";
				String deferredLink = "//span[normalize-space()='Deferred']";
			}
			// locators for NPSP Sales force - self
			public interface SF_Locators {
				
				String SF_LOGIN_BTM_MAIN = "/html/body/div[5]/div/div/header/div[3]/div/div/div[1]/div[1]/div[2]/button";
				String SF_LOGIN_BTN = "/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/input[3]";
				String CAMPAIGN_OBJ = "/html/body/div[4]/div[1]/div[2]/div[2]/div/div[2]/div/section/div/div[2]/div/div/div/div[2]/div/div[2]/div/table/tbody/tr[11]/th/a";
				String PAGE_LAYOUTS_LINK = "/html/body/div[4]/div[1]/div[2]/div[2]/div/div[2]/div/section/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/ul/li[3]/a";
				String FIRST_LAYOUT_LINK = "/html/body/div[4]/div[1]/div[2]/div[2]/div/div[2]/div/section/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/section/div/div[2]/div/div/table/tbody/tr/td[1]/a/span";
				String SF_USERNAME_FIELD = "/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[2]/div/input[1]";
				String SF_PW_FIELD = "/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/input[2]";
				
				//SF obj manager locators
				String objManager = "/html/body/div[4]/div[1]/div[2]/header/div[3]/div/div[2]/div/div/ul[2]/li[3]/a/span";
				String object1 = "/html/body/div[4]/div[1]/div[2]/div[2]/div/div[2]/div/section/div/div[2]/div/div/div/div[2]/div/div[2]/div/table/tbody/tr[2]/th/a";
				String createLink = "/html/body/div[4]/div[1]/div[2]/div[2]/div/div[2]/div/section/div/div[2]/div/div/div/div[1]/div/div[2]/div[3]/div/div[1]/div/div/a/span";
				String createObjLink = "/html/body/div[4]/div[1]/div[2]/div[2]/div/div[2]/div/section/div/div[2]/div/div/div/div[1]/div/div[2]/div[3]/div/div[2]/div/ul/li[1]/a/div/div/span/span";
				String helplink = "/html/body/div[1]/div[1]/div[2]/a";	
				String newObjectFrame = "//*[@id=\"setupComponent\"]/div[2]/div/div/force-aloha-page/div/iframe";
				String newObjLabel = "/html//input[@id='MasterLabel']";				
				String newObjPlural = "/html//input[@id='PluralLabel']";				
				String newObjDesc = "/html//textarea[@id='Description']";
				String lastModifiedLink = "//th[@aria-label='Last Modified']";
				String profileIcon = "/html/body/div[4]/div[1]/div[2]/header/div[2]/span/div[2]/ul/li[8]/span/button/div/span[1]/div";
				String logOutLink = "/html/body/div[4]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/a[2]";
			}
			
			// locators for NPSP Sales force -self
			public interface NPSP_Locators {
				String contactsLink = "//span[normalize-space()='Contacts']";
				String user_name = "//input[@id='username']";
				String password = "//input[@id='password']";
				String login_button = "//input[@id='Login']";
				String firstContact = "//tbody/tr[1]/th[1]/span[1]";
				String secondContact = "//tbody/tr[2]/th[1]/span[1]";
				String firstAcct = "//tbody/tr[1]/td[3]/span[1]";
				String secondAcct = "//tbody/tr[2]/td[3]/span[1]";
						
			}
			
}

