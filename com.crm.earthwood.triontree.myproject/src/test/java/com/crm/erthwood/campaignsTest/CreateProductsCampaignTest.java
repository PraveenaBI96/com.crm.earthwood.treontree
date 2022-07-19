package com.crm.erthwood.campaignsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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

public class CreateProductsCampaignTest {
	
	public static void main(String[]args) throws Throwable{
		// Creating object for Utility
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib = new JavaUtility();   
		
		// launch the browser and application
		WebDriver driver=wLib.launchBrowser(fLib.getPropertyKeyValue("browser"));

        // Login to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToVtiger(fLib.getPropertyKeyValue("url"),fLib.getPropertyKeyValue("username"), fLib.getPropertyKeyValue("password"));
	    
		// Click on Products Module
		HomePage home = new HomePage(driver);
	    home.getProducts().click();
	    
	    // Click on create new Products Icon
	    ProductsPage pp=new ProductsPage(driver);
	    pp.getCreateProductsIcon().click();
	    
	    // Creating new Product by passing Product info
	    CreatingNewProductsPage cnp=new CreatingNewProductsPage(driver);
	    String actprodname=cnp.createProduct();
	    
	    // Move mouse cursor on to more and Click on Campaign Module
	    WebElement more = home.getMore();
	    wLib.moveOverOnElement(driver,more); 
	    home.getCampaigns().click();
	    
	    // Click on create new Campaign icon
	    CampaignPage cp=new CampaignPage(driver);
	    cp.getCreateCampaign().click();
	    
	    // Creating campaign by passing the Product name created Above
	    String title=driver.getTitle(); 
	    String partialWindowUrl= eLib.getDataFromExcel("Campaign", 3, 5);
	    CreatingNewCampaignPage cnc=new CreatingNewCampaignPage(driver);
	    String actualname= cnc.createCampaignProduct(driver, actprodname, partialWindowUrl,title);	
		
	    // Verify Campaign
		CampaignInformationPage campInfo=new CampaignInformationPage(driver);
		String expectedname = campInfo.getCampaignInfo().getText();
		Assert.assertTrue(expectedname.contains(actualname));
//		if(expectedname.contains(actualname))
//		{
//			System.out.println("Campaign created Successfully");
//		}
//		else
//			System.out.println("Campaign creation Failed");
		
		// Logout Application
		home.logoutVtiger(driver);
		
		// Close Browser
		driver.close();
	}
}
