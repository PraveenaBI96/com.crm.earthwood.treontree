package com.crm.earthwood.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.earthwood.genericUtility.WebDriverUtility;

public class CampaignPage {
public CampaignPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createCampaign;
	public WebElement getCreateCampaign() {
		return createCampaign;
	}
}
