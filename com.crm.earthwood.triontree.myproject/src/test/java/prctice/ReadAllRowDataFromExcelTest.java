package prctice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllRowDataFromExcelTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./data/vTiger.xlsx");
    Workbook book = WorkbookFactory.create(fis);
    Sheet sh=book.getSheet("Sheet1");
    DataFormatter format=new DataFormatter();
    int count =sh.getLastRowNum();
    for(int i=0;i<=count;i++)
    {
    	String firstcolumn = format.formatCellValue(sh.getRow(i).getCell(0));
    	String secondcolumn = format.formatCellValue(sh.getRow(i).getCell(1));
    	System.out.println(firstcolumn+"\t"+secondcolumn);
    }
   
}
}
