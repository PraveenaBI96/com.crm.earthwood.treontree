package prctice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AddDataToExcelTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("C:\\Users\\Praveen\\Documents\\Selenium note\\vTiger.xlsx");
    Workbook book = WorkbookFactory.create(fis);
    Sheet sh=book.getSheet("Sheet1");
    DataFormatter format=new DataFormatter();
    Cell cell=sh.getRow(0).createCell(2);
    cell.setCellValue("vtiger");
    FileOutputStream fos=new FileOutputStream("C:\\Users\\Praveen\\Documents\\Selenium note\\vTiger.xlsx");
    book.write(fos);
    for(int i=0;i<=sh.getLastRowNum();i++)
    {
    	Row row=sh.getRow(i);
    	for(int j=0;j<=row.getLastCellNum();j++)
    	{
    		System.out.print(format.formatCellValue(row.getCell(j))+"\t");
    	}
    	System.out.println();
    }
    book.close(); 
}
}
