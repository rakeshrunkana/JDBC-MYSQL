package com.SelectExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchRecord {
	
	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";
	
	public static void main(String [] args) throws Exception{
		System.out.println("Database connected!! ");
		Connection con=DriverManager.getConnection(DB_URL,USER,PASSWORD);
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=stmt.executeQuery("select* from Employees");
	
		//Getting the record of 3rd row
		rs.absolute(3);
		System.out.println(rs.getString(1)+ " " + rs.getString(2)+" " + rs.getString(3)+ " " + rs.getString(4));
		con.close();
	}

}
