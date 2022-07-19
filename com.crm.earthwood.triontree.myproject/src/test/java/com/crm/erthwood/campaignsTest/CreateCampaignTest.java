package com.crm.erthwood.campaignsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.earthwood.genericUtility.BaseClass;
import com.crm.earthwood.genericUtility.ExcelUtility;
import com.crm.earthwood.genericUtility.FileUtility;
import com.crm.earthwood.genericUtility.JavaUtility;
import com.crm.earthwood.genericUtility.WebDriverUtility;
import com.crm.earthwood.pomRepository.CampaignInformationPage;
import com.crm.earthwood.pomRepository.CampaignPage;
import com.crm.earthwood.pomRepository.CreatingNewCampaignPage;
import com.crm.earthwood.pomRepository.CreatingNewProductsPage;
import com.crm.earthwood.pomRepository.HomePage;
import com.crm.earthwood.pomRepository.LoginPage;
import com.crm.earthwood.pomRepository.ProductsPage;

public class CreateCampaignTest
{
	 public static void main(String[] args) throws Throwable {
    // Creating object for Utility
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
     
		// launch the browser and application
		WebDriver driver=wLib.launchBrowser(fLib.getPropertyKeyValue("browser"));		
		// login to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToVtiger(fLib.getPropertyKeyValue("url"),fLib.getPropertyKeyValue("username"),fLib.getPropertyKeyValue("password"));
		
		// go to more and Click on to Campaign module
		HomePage home = new HomePage(driver);
		WebElement more =home.getMore();
		wLib.moveOverOnElement(driver,more);
		home.getCampaigns().click();
		
		// click on to create new Campaign icon
		CampaignPage cp=new CampaignPage(driver);
		cp.getCreateCampaign().click();
		
		// it's used to pass the campaign information and to create a new campaign
		CreatingNewCampaignPage cnc=new CreatingNewCampaignPage(driver);
		String actualname=cnc.createCampaign();
		
		// it's used to verify the campaign information
		CampaignInformationPage campInfo=new CampaignInformationPage(driver);
		String expectedname = campInfo.getCampaignInfo().getText();
		System.out.println(expectedname);
		Assert.assertTrue(expectedname.contains(actualname));
//		if(expectedname.contains(actualname))
//		{
//			System.out.println("Campaign created Successfully");
//		}else
//			System.out.println("Campaign creation failed");
	
	// Logout Application
	home.logoutVtiger(driver);
	
	// Close Browser
	driver.close();
}
}

