package prctice;

import org.testng.annotations.DataProvider;

import com.crm.earthwood.genericUtility.ExcelUtility;

public class dataProvider {
	@DataProvider
public Object[][] dataSupplier() throws Throwable
{
	Object[][] objArr=new Object[5][2];
	 ExcelUtility eLib = new ExcelUtility();
	 int m=2;
	 for(int i=0;i<5;i++)
	 {
		 int n=3;
		 for(int j=0;j<2;j++)
			 { 
				 objArr[i][j]=eLib.getDataFromExcel("DataSupplier", m , n);
				 n++;
			 }
		 m++;
	 } 
	return objArr;
}
}
