package com.crm.earthwood.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.earthwood.genericUtility.WebDriverUtility;

public class ContactInformationPage  {
	WebDriver driver;
	public ContactInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(className="dvHeaderText")
private WebElement contactInfo;
@FindBy(xpath="//td[@class='dvtTabCache'] /../td[5]/input[3]")
private WebElement deleteButton;
@FindBy(xpath="//input[@class='txtBox']")
private WebElement searchFor;
@FindBy(id="bas_searchfield")
private WebElement searchIn;
@FindBy(name="submit")
private WebElement searchNowbutton;
@FindBy(xpath="//span[contains(text(),'No Contact')]")
private WebElement confirmationmsg;

public WebElement getDeleteButton() {
	return deleteButton;
}

public WebElement getSearchFor() {
	return searchFor;
}

public WebElement getSearchIn() {
	return searchIn;
}

public WebElement getSearchNowbutton() {
	return searchNowbutton;
}

public WebElement getConfirmationmsg() {
	return confirmationmsg;
}

public WebElement getContactInfo() {
	return contactInfo;
	
}
}
