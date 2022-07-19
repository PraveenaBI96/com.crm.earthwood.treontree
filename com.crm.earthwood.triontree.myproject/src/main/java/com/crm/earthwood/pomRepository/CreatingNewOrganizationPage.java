package com.crm.earthwood.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.earthwood.genericUtility.ExcelUtility;
import com.crm.earthwood.genericUtility.JavaUtility;
import com.crm.earthwood.genericUtility.WebDriverUtility;

public class CreatingNewOrganizationPage {
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//td[@class='dvtCellInfo']/input[@name='accountname']")
private WebElement organizationNameTF;
@FindBy(xpath="//td[@class='dvtCellLabel']/../preceding-sibling::tr/td/div/input[@value='  Save  ']")
private WebElement saveButton;

public WebElement getOrganizationNameTF() {
	return organizationNameTF;
}
public WebElement getSaveButton() {
	return saveButton;
}
public String createOrganization() throws Throwable
{
	ExcelUtility eLib = new ExcelUtility();
    JavaUtility jLib = new JavaUtility();
	String orgname = eLib.getDataFromExcel("Organization", 2, 3);
    int random= jLib.randomNum();
    String actualname=orgname+random;
    getOrganizationNameTF().sendKeys(actualname);
    getSaveButton().click();
    return actualname;
}
}
