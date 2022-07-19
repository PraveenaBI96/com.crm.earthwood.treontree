package com.crm.erthwood.contactsTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.earthwood.genericUtility.BaseClass;

import com.crm.earthwood.pomRepository.ContactInformationPage;
import com.crm.earthwood.pomRepository.ContactsPage;
import com.crm.earthwood.pomRepository.CreatingNewContactPage;
import com.crm.earthwood.pomRepository.HomePage;

@Listeners(com.crm.earthwood.genericUtility.ListenerImplementation.class)
public class ContactsTest extends BaseClass {
@Test(groups = {"smoke","regression"})
public void createContactTest() throws Throwable
{
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
//			if(expectedname.contains(actualname))
//			{
//				System.out.println("Contact created Successfully");
//			}else
//				System.out.println("Contact creation failed");
}
@Test(groups = "smoke")
public void createContactOrganizationTest() throws Throwable
{
	// Click on contacts Module
			HomePage home = new HomePage(driver);
			home.getContacts().click();
			
			// Click on create new Contact Icon
			ContactsPage cp=new ContactsPage(driver);
			cp.getCreateContact().click();
			
			// creating new Contact by passing mandatory Fields
		    CreatingNewContactPage  cn =new CreatingNewContactPage(driver);
		    String actualname=cn.createContactOrganizationname(driver,eLib.getDataFromExcel("Contacts", 4, 5),eLib.getDataFromExcel("Contacts", 4, 3),eLib.getDataFromExcel("Contacts", 4, 4));
		    
		    // Verify Contact Info
		    ContactInformationPage cInfo= new ContactInformationPage(driver);
		    String expectedname=cInfo.getContactInfo().getText();
			System.out.println(expectedname);
			 Assert.assertTrue(expectedname.contains(actualname));
//			if(expectedname.contains(actualname))
//			{
//				System.out.println("Contact created Successfully");
//			}else
//				System.out.println("Contact creation failed");
}
@Test(groups = "regression")
public void createAndDeleteContactTest() throws Throwable
{
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
//			if(msg.contains("No Contact Found !"))
//			{
//				System.out.println("Contact Deleted Successfully");
//			}
//			else
//				System.out.println("Contact not Deleted");
}
}
