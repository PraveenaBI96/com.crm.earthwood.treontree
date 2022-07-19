package prctice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.earthwood.genericUtility.ExcelUtility;

public class DataProviderExcelTest extends dataProvider {
	
	@Test(dataProvider="dataSupplier")
	
public void bookTicket(String src, String desc)
{
	System.out.println("book ticket From \t"+src+"\t To \t"+desc);
}

}
