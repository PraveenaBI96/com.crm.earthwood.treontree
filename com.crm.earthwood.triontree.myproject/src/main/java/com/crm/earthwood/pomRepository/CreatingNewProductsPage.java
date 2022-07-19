package com.crm.earthwood.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.earthwood.genericUtility.ExcelUtility;
import com.crm.earthwood.genericUtility.JavaUtility;
import com.crm.earthwood.genericUtility.WebDriverUtility;

public class CreatingNewProductsPage {
public CreatingNewProductsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(name="productname")
private WebElement productName;
@FindBy(xpath="//td[@class='dvtCellLabel']/../../tr[1]/td[1]/div/input[1]")
private WebElement saveButton;
public WebElement getProductName() {
	return productName;
}
public WebElement getSaveButton() {
	return saveButton;
}
	public String createProduct() throws Throwable
	{
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib = new JavaUtility();   
		String prodname=eLib.getDataFromExcel("Campaign", 3, 3);
	    int random= jLib.randomNum();
	    String actprodname=prodname+random;
		getProductName().sendKeys(actprodname);
		getSaveButton().click();
		return actprodname;
    }
}
