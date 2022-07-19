package com.crm.earthwood.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.crm.earthwood.genericUtility.BaseClass;
import com.crm.earthwood.genericUtility.WebDriverUtility;

public class LoginPage {
	WebDriver driver;
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

	@FindBy(name="user_name")
	private WebElement usernameTF;
	@FindBy(name="user_password")
	private WebElement passwordTF;
	@FindBy(id="submitButton")
	private WebElement loginButton;
	public WebElement getUsernameTF() {
		return usernameTF;
	}
	public WebElement getPasswordTF() {
		return passwordTF;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	/**
	 * This method is used to login to the Application
	 * @param username
	 * @param password
	 */
	public void loginToVtiger(String url,String username,String password)
	{
		driver.get(url);
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		getLoginButton().click();
	}
}