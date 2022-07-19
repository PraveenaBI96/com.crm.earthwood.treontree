package prctice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
//	@Test (dataProvider ="dataSupplier")
//public void bookTicket(String src,String dst)
//{
//	System.out.println("Book Ticket From\t"+src+"\tTo\t"+dst);
//}
@DataProvider
public Object[][] dataSupplier()
{
	Object[][] objArr=new Object[3][2];
	objArr[0][0]="Bng";
	objArr[0][1]="Mys";
	
	objArr[1][0]="HSN";
	objArr[1][1]="Ckm";
	
	objArr[2][0]="Mys";
	objArr[2][1]="Hsn";
	return objArr;
}
}
