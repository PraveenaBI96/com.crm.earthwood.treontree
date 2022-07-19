package prctice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NoSelectQueryTest 
{
public static void main(String[] args) throws SQLException {
	Connection conn= null;
	int Result =0;
	try
	{
	Driver driverRef = new Driver();
//	Register to DB
	DriverManager.registerDriver(driverRef);
//	Connection to DB
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
	System.out.println("Connected to DB");
//	Create Query Statement
	Statement state = conn.createStatement();
	String query="insert into students_info (regno, firstName, middleName, lastName) values('9', 'pravi','gowda', 'BI')";
//	Execute Query
	Result =state.executeUpdate(query);
	}
	catch(Exception e)
	{}
	finally
	{
		System.out.println(Result);
		if(Result==1)
		{
			System.out.println("Student inserted Successfully");
		}else
			System.out.println("Student insertion Failed");
		conn.close();
		System.out.println("DB Connection Closed");
	}
}
}
