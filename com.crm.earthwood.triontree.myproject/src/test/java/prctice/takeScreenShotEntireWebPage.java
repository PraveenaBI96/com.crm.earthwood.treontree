package prctice;

import org.openqa.selenium.WebDriver;

import com.crm.earthwood.genericUtility.ExcelUtility;
import com.crm.earthwood.genericUtility.FileUtility;
import com.crm.earthwood.genericUtility.JavaUtility;
import com.crm.earthwood.genericUtility.WebDriverUtility;
import com.crm.earthwood.pomRepository.HomePage;
import com.crm.earthwood.pomRepository.LoginPage;

public class takeScreenShotEntireWebPage {
	public static void main(String[] args) throws Throwable {
		// Creating object for Utility
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
	    ExcelUtility eLib = new ExcelUtility();
	    JavaUtility jLib = new JavaUtility();
	    
	    // launch the browser and application
		WebDriver driver=wLib.launchBrowser(fLib.getPropertyKeyValue("browser"));
		
		// login to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToVtiger(fLib.getPropertyKeyValue("url"),fLib.getPropertyKeyValue("username"), fLib.getPropertyKeyValue("password"));
		
		// Click on Organizatrions Module
		HomePage home = new HomePage(driver);
		home.getOrganizations().click();
		wLib.takesScreenShotEntirePage();
	}
}
