package com.crm.erthwood.campaignsTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.earthwood.genericUtility.BaseClass;
import com.crm.earthwood.pomRepository.CampaignInformationPage;
import com.crm.earthwood.pomRepository.CampaignPage;
import com.crm.earthwood.pomRepository.CreatingNewCampaignPage;
import com.crm.earthwood.pomRepository.CreatingNewProductsPage;
import com.crm.earthwood.pomRepository.HomePage;
import com.crm.earthwood.pomRepository.ProductsPage;

@Listeners(com.crm.earthwood.genericUtility.ListenerImplementation.class)
public class CampaignsTest extends BaseClass {
	@Test(groups = "regression")
	public void createCampaignTest() throws Throwable
	{	
		// go to more and Click on to Campaign module
		HomePage home =new HomePage(driver);
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
//		 Assert.assertEquals(expectedname, actualname);
//		if(expectedname.contains(actualname))
//		{
//			System.out.println("Campaign created Successfully");
//		}else
//			System.out.println("Campaign creation failed");
	}
	@Test(groups = "smoke")
	public void createProductsCampaignTest() throws Throwable 
	{   
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
	}

}
