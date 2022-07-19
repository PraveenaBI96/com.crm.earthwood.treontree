
package com.crm.erthwood.contactsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.internal.ReporterConfig;

import com.crm.earthwood.genericUtility.ExcelUtility;
import com.crm.earthwood.genericUtility.FileUtility;
import com.crm.earthwood.genericUtility.JavaUtility;
import com.crm.earthwood.genericUtility.WebDriverUtility;
import com.crm.earthwood.pomRepository.ContactInformationPage;
import com.crm.earthwood.pomRepository.ContactsPage;
import com.crm.earthwood.pomRepository.CreatingNewContactPage;
import com.crm.earthwood.pomRepository.HomePage;
import com.crm.earthwood.pomRepository.LoginPage;

public class CreateContactTest extends WebDriverUtility
{
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
		
		// Click on Create New Contact Icon
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContact().click();
		
		// Creating new Contact with mandatory fields 
	    CreatingNewContactPage  cn =new CreatingNewContactPage(driver);
	    String actualname=cn.createContactMandatoryFields(driver);
	    
	    // Verify Contact info
	    ContactInformationPage cInfo= new ContactInformationPage(driver);
	    String expectedname=cInfo.getContactInfo().getText();
	    System.out.println(expectedname);
	    Assert.assertTrue(expectedname.contains(actualname));
	    Reporter.log("Passed",true);
//		if(expectedname.contains(actualname))
//		{
//			System.out.println("Contact created Successfully");
//		}else
//			System.out.println("Contact creation failed");
		
		// Logout Application
		home.logoutVtiger(driver);
		
		// Close Browser
		driver.close();
	}
}

