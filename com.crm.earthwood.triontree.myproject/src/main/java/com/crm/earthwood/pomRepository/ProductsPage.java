package com.crm.earthwood.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.earthwood.genericUtility.WebDriverUtility;

public class ProductsPage {
public ProductsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//img[@title='Create Product...']")
private WebElement createProductsIcon;
public WebElement getCreateProductsIcon() {
	return createProductsIcon;
}

}
