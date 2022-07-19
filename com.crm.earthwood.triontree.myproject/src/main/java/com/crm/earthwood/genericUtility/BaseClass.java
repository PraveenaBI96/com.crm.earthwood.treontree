package com.crm.earthwood.genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.earthwood.pomRepository.HomePage;
import com.crm.earthwood.pomRepository.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	public static WebDriver listenerDriver;
	public WebDriverUtility wLib;
	// Creating object for Utility
		public FileUtility fLib = new FileUtility();
		public ExcelUtility eLib = new ExcelUtility();
		public JavaUtility jLib = new JavaUtility();
		
	@BeforeSuite(alwaysRun=true)
	public void connectToDB()
	{
		System.out.println("Connected to DB");
	}

	@BeforeClass(alwaysRun=true)                  
	public void launchBrowser() throws Throwable
	{
		wLib= new WebDriverUtility();
		String browser=System.getProperty("Browser");
//		String browser=fLib.getPropertyKeyValue("browser");
		driver=wLib.launchBrowser(browser);
		listenerDriver = driver;
	}
//	@Parameters("browserName")
//	@BeforeClass(alwaysRun=true)                  
//	public void launchCrssBrowser() throws Throwable
//	{
////		String browser=fLib.getPropertyKeyValue("browser");
//		String browserName= System.getProperty("BROWSER");
//		if(browserName.equalsIgnoreCase("Chrome"))
//		{
//			driver= new ChromeDriver();	
//		}else 
//			if(browserName.equalsIgnoreCase("Firefox"))
//			{
//				driver= new FirefoxDriver();
//			}else
//				if(browserName.equalsIgnoreCase("Edge"))
//				{
//					driver=new EdgeDriver();
//				}
//		listenerDriver = driver;
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
//		driver=wLib.launchBrowser(browser);
//	}
	@BeforeMethod(alwaysRun=true)
	public void loginToVtiger() throws Throwable
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToVtiger(fLib.getPropertyKeyValue("url"),fLib.getPropertyKeyValue("username"),fLib.getPropertyKeyValue("password"));	
	}
	@AfterMethod(alwaysRun=true)
	public void logoutVtiger()
	{
		HomePage homePage= new HomePage(driver);
		homePage.logoutVtiger(driver);
	}
	@AfterClass(alwaysRun=true)
	public void closeBrowser()
	{
		driver.close();
	}
	@AfterSuite(alwaysRun=true)
	public void closeDB()
	{
		System.out.println("DataBase Closed");
	}
}
