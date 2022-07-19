package prctice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FindDataAndGetValueFromExcelTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./data/vTiger.xlsx");
    Workbook book = WorkbookFactory.create(fis);
    Sheet sh=book.getSheet("Sheet1");
    DataFormatter format=new DataFormatter();
    int count=sh.getLastRowNum();
    String expecteddata="username";
    for(int i=0;i<=count;i++)
    {
    	String value=format.formatCellValue(sh.getRow(i).getCell(0));
    	if(value.equals(expecteddata))
    	{
    		System.out.println(format.formatCellValue(sh.getRow(i).getCell(1)));
    	}
    }
}
}
