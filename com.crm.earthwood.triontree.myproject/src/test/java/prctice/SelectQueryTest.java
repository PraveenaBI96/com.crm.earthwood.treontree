package prctice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest 
{
public static void main(String[] args) throws SQLException {
	Connection conn= null;
	try
	{
	Driver driverRef=new Driver();
//	Register to the DataBase
	DriverManager.registerDriver(driverRef);
//	Connection to the dataBase
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	System.out.println("Connected to database");
//	Create Query Statement
	Statement state= conn.createStatement();
	String Query = "select * from students_info";
//	Execute the query
	ResultSet resultset=state.executeQuery(Query);
	while(resultset.next())
	{
		System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
	}
	}catch(Exception e)
	{}
	finally
	{
		conn.close();
		System.out.println("DB Connection closed");
	}
}
}
