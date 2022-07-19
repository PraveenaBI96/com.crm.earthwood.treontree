package com.cmr.erthwood.organizationsTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.crm.earthwood.genericUtility.ExcelUtility;
import com.crm.earthwood.genericUtility.FileUtility;
import com.crm.earthwood.genericUtility.JavaUtility;
import com.crm.earthwood.genericUtility.WebDriverUtility;
import com.crm.earthwood.pomRepository.CreatingNewOrganizationPage;
import com.crm.earthwood.pomRepository.HomePage;
import com.crm.earthwood.pomRepository.LoginPage;
import com.crm.earthwood.pomRepository.OrganizationInformationPage;
import com.crm.earthwood.pomRepository.OrganizationsPage;

public class CreateOrganizationTest {
	public static void main(String[] args) throws Throwable {
		// Creating object for Utility
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
	    ExcelUtility eLib = new ExcelUtility();
	    JavaUtility jLib = new JavaUtility();
	    
	    // launch the browser and application
		WebDriver driver=wLib.launchBrowser(fLib.getPropertyKeyValue("browser"));
		
		// login to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToVtiger(fLib.getPropertyKeyValue("url"),fLib.getPropertyKeyValue("username"), fLib.getPropertyKeyValue("password"));
		
		// Click on Organizatrions Module
		HomePage home = new HomePage(driver);
		home.getOrganizations().click();
		
		// Click on create new Organization Icon
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrganizationIcon().click();	
		
		// Creating Organization by passing organization info
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		String actualname=cno.createOrganization();
		
		// Verify Organization 
		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		String expectedname =orgInfo.getOrgInfo().getText();
		System.out.println(expectedname);
		Assert.assertTrue(expectedname.contains(actualname));
//		if(expectedname.contains(actualname))
//		{
//			System.out.println("Organization created Successfully");
//		}else
//			System.out.println("Organization creation failed");
		
		// Logout the Application
		home.logoutVtiger(driver);
		
		// Close the Browser
		driver.close();
	}
}
