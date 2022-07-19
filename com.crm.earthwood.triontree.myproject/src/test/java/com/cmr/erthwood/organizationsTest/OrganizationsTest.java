package com.cmr.erthwood.organizationsTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.earthwood.genericUtility.BaseClass;
import com.crm.earthwood.pomRepository.CreatingNewOrganizationPage;
import com.crm.earthwood.pomRepository.HomePage;
import com.crm.earthwood.pomRepository.OrganizationInformationPage;
import com.crm.earthwood.pomRepository.OrganizationsPage;
@Listeners(com.crm.earthwood.genericUtility.ListenerImplementation.class)
public class OrganizationsTest extends BaseClass {
	@Test(retryAnalyzer=com.crm.earthwood.genericUtility.RetryAnalyzerImplementation.class)
	public void creteOrgnition() throws Throwable {
		// Click on Organizations Module
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
//		 Assert.assertEquals(expectedname, actualname);
//		if(expectedname.contains(actualname))
//		{
//			System.out.println("Organization created Successfully");
//		}else
//			System.out.println("Organization creation failed");
	}
}
