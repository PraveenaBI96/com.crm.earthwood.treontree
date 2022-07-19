package com.crm.earthwood.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.earthwood.genericUtility.ExcelUtility;
import com.crm.earthwood.genericUtility.JavaUtility;
import com.crm.earthwood.genericUtility.WebDriverUtility;

public class CreatingNewCampaignPage {

	public CreatingNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="campaignname")
	private WebElement campaignName;
	@FindBy(xpath="//td[@class='dvtCellLabel']/../../tr/td/div/input[@class='crmButton small save']")
	private WebElement saveButton;
	@FindBy(xpath="//td[@class='dvtCellInfo']/img[@alt='Select']")
	private WebElement productIcon;
	@FindBy(id="search_txt")
	private WebElement searchTF;
	@FindBy(name="search")
	private WebElement searchNowButton;
	@FindBy(xpath="//a[@id='1']")
	private WebElement selectProduct;
	
	public WebElement getProductIcon() {
		return productIcon;
	}
	public WebElement getSearchTF() {
		return searchTF;
	}
	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
	public WebElement getSelectProduct() {
		return selectProduct;
	}
	public WebElement getCampaignName() {
		return campaignName;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public String createCampaign() throws Throwable
	{
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		String campaignname=eLib.getDataFromExcel("Campaign", 2, 3);
		int random=jLib.randomNum();
	    String actualname=campaignname+random;
	    getCampaignName().sendKeys(actualname);
	    getSaveButton().click();
	    return actualname;
	} 
	
	public String createCampaignProduct(WebDriver driver,String actprodname,String partialWindowUrl,String partialWindowTitle) throws Throwable
	{
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib = new JavaUtility();	
		String campaignname=eLib.getDataFromExcel("Campaign", 2, 3);
		int random=jLib.randomNum();
	    String actualname=campaignname+random;
	    getCampaignName().sendKeys(actualname);
	    getProductIcon().click();
	    wLib.switchToWindowUrl(driver,partialWindowUrl);
	    getSearchTF().sendKeys(actprodname);
	    getSearchNowButton().click();
	    WebElement element=getSelectProduct();
        Thread.sleep(2000);
	    getSelectProduct().click();
	    wLib.switchToWindow(driver,partialWindowTitle);
		getSaveButton().click();
	    return actualname;
	}
}
