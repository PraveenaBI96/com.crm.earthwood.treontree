package prctice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromExcelSheetTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/vTiger.xlsx");
	    Workbook book = WorkbookFactory.create(fis);
	    Sheet sh=book.getSheet("Sheet1");
	    DataFormatter format=new DataFormatter();
	    String url= format.formatCellValue(sh.getRow(0).getCell(1));
	    String username =format.formatCellValue(sh.getRow(2).getCell(1));
	    String pwd= format.formatCellValue(sh.getRow(3).getCell(1));
	    WebDriver driver = new ChromeDriver();
	    driver.get(url);
	    driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		driver.close();
	}
}
