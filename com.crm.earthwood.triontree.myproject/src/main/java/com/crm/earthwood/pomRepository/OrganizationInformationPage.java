package com.crm.earthwood.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.earthwood.genericUtility.WebDriverUtility;

public class OrganizationInformationPage {

	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgInfo() {
		return orgInfo;
	}
	@FindBy(className="dvHeaderText")
	private WebElement orgInfo;
}
