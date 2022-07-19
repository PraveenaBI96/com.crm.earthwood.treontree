package com.crm.earthwood.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.earthwood.genericUtility.WebDriverUtility;

public class ContactsPage {
	WebDriver driver;
public ContactsPage(WebDriver driver)
{
		this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContact;
	public WebElement getCreateContact() {
		return createContact;
	}
	
}
