package prctice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.earthwood.genericUtility.ExcelUtility;

public class DataProviderActiTime {
	@Test(dataProvider="dataSupplier")
	public void loginActiTime(String usn, String pwd) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys(usn);
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		Thread.sleep(3000);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000);
		driver.close();
	}
	@DataProvider
public Object[][] dataSupplier() throws Throwable
{
	Object[][] objArr=new Object[5][2];
	 ExcelUtility eLib = new ExcelUtility();
	objArr[0][0]=eLib.getDataFromExcel("DataSupplier", 2, 3);
	objArr[0][1]=eLib.getDataFromExcel("DataSupplier", 2, 4);
	
	objArr[1][0]=eLib.getDataFromExcel("DataSupplier", 3, 3);
	objArr[1][1]=eLib.getDataFromExcel("DataSupplier", 3, 4);
	
	objArr[2][0]=eLib.getDataFromExcel("DataSupplier", 4, 3);
	objArr[2][1]=eLib.getDataFromExcel("DataSupplier", 4, 4);
	
	objArr[3][0]=eLib.getDataFromExcel("DataSupplier", 5, 3);
	objArr[3][1]=eLib.getDataFromExcel("DataSupplier", 5, 4);
	
	objArr[4][0]=eLib.getDataFromExcel("DataSupplier", 6, 3);
	objArr[4][1]=eLib.getDataFromExcel("DataSupplier", 6, 4);
	
	return objArr;
	
}

}
