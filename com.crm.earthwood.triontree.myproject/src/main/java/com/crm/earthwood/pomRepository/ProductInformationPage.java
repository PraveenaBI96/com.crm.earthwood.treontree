package com.crm.earthwood.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.earthwood.genericUtility.WebDriverUtility;

public class ProductInformationPage {
public ProductInformationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[text()='More']")
private WebElement more;
public WebElement getMore() {
	return more;
}
}
