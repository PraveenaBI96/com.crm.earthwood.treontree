package com.crm.erthwood.contactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.crm.earthwood.genericUtility.ExcelUtility;
import com.crm.earthwood.genericUtility.FileUtility;
import com.crm.earthwood.genericUtility.JavaUtility;
import com.crm.earthwood.genericUtility.WebDriverUtility;
import com.crm.earthwood.pomRepository.ContactInformationPage;
import com.crm.earthwood.pomRepository.ContactsPage;
import com.crm.earthwood.pomRepository.CreatingNewContactPage;
import com.crm.earthwood.pomRepository.HomePage;
import com.crm.earthwood.pomRepository.LoginPage;

public class CreateAndDeleteContactTest {
	public static void main(String[] args) throws Throwable {
		// Creating object for Utility
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
		// launch the browser and application
		WebDriver driver= wLib.launchBrowser(fLib.getPropertyKeyValue("browser"));
		
		// login to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToVtiger(fLib.getPropertyKeyValue("url"),fLib.getPropertyKeyValue("username"), fLib.getPropertyKeyValue("password"));
		
		// Click on Contacts Module
		HomePage home = new HomePage(driver);
		home.getContacts().click();
		
		// Click on create new Contact Icon
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();
		
		// Creating new Contact by passing Mandatory Fields
		CreatingNewContactPage cn = new CreatingNewContactPage(driver);
		String actualname=cn.createContactMandatoryFields(driver);
		
		// Deleting the Contact 
		ContactInformationPage cInfo = new ContactInformationPage(driver);
		cInfo.getDeleteButton().click();
		wLib.switchToAlertAndAccept(driver,actualname);
		
		// Verifying the Contact info
		cInfo.getSearchFor().sendKeys(actualname);
		WebElement drop =cInfo.getSearchIn();
		wLib.selectByVisibleTex(drop, "Last Name");
		cInfo.getSearchNowbutton().click();
		String msg =cInfo.getConfirmationmsg().getText();
		Assert.assertEquals(msg, "No Contact Found !");
//		if(msg.contains("No Contact Found !"))
//		{
//			System.out.println("Contact Deleted Successfully");
//		}
//		else
//			System.out.println("Contact not Deleted");	
		
		// Logout Application
		home.logoutVtiger(driver);
		
		// Close Browser
		driver.close();
}
}