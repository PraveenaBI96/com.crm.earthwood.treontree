package com.crm.earthwood.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.earthwood.genericUtility.WebDriverUtility;

public class CampaignInformationPage{
    public CampaignInformationPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    @FindBy(className="dvHeaderText")
    private WebElement campaignInfo;
	public WebElement getCampaignInfo() {
		return campaignInfo;
	}
	
}
