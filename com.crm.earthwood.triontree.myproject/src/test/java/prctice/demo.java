package prctice;

public class demo
{
	int driver;
	{
		this.driver=30;
	}
	public  int method()
	{
		
		driver=20;
		return driver;
	}
	public static void main(String[] args) 
	{
		int driver=20;
		demo d=new demo();
		d.driver=50;
		System.out.println(d.driver);
		System.out.println(driver);
	}
}