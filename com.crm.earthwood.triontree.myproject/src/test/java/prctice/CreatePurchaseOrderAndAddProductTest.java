package prctice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.earthwood.genericUtility.ExcelUtility;
import com.crm.earthwood.genericUtility.FileUtility;
import com.crm.earthwood.genericUtility.JavaUtility;
import com.crm.earthwood.genericUtility.WebDriverUtility;

public class CreatePurchaseOrderAndAddProductTest {
	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		wLib.implicitWait();
		driver.get(fLib.getPropertyKeyValue("url"));             
		driver.findElement(By.name("user_name")).sendKeys(fLib.getPropertyKeyValue("username"));
		driver.findElement(By.name("user_password")).sendKeys(fLib.getPropertyKeyValue("password"));
		driver.findElement(By.id("submitButton")).click();
		WebElement more =  driver.findElement(By.xpath("//a[.='More']"));
		wLib.moveOverOnElement(driver,more);
		driver.findElement(By.name("Purchase Order")).click();
		driver.findElement(By.cssSelector("[title='Create Purchase Order...']")).click();
		int random=jLib.randomNum();
		String subject =eLib.getDataFromExcel("Purchase Order", 2, 3);
	    String vendername =eLib.getDataFromExcel("Purchase Order", 2, 4);
	    String billstreet =eLib.getDataFromExcel("Purchase Order", 2, 5);
	    String shipstreet =eLib.getDataFromExcel("Purchase Order", 2, 6);
		driver.findElement(By.name("subject")).sendKeys(subject);
		
		driver.findElement(By.name("bill_street")).sendKeys(billstreet);
		driver.findElement(By.name("ship_street")).sendKeys(shipstreet);
		driver.findElement(By.id("searchIcon1")).click();
		String title=driver.getTitle();
		String partialWindowUrl= eLib.getDataFromExcel("Campaign", 3, 5);
		wLib.switchToWindowUrl(driver, partialWindowUrl);
		driver.findElement(By.id("search_txt")).sendKeys("Titan9352");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.id("popup_product_41")).click();
        wLib.switchToWindow(driver,title);
		WebElement signout = driver.findElement(By.xpath("//td[@class='genHeaderSmall']/following-sibling::td[1]/img"));
		wLib.moveOverOnElement(driver,signout);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
}
}