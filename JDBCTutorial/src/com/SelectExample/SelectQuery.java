package com.SelectExample;

import java.sql.*;

public class SelectQuery {
	
	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";

	public static void main(String[] args) throws Exception {
		Connection con=DriverManager.getConnection(DB_URL,USER,PASSWORD);
		System.out.println("Connected to the Database!");
		Statement stmt=con.createStatement();
		String sql="Select last, first from Registration where id=100";
		stmt.executeQuery(sql);
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println("FirstName " + "LastName ");
			System.out.println(rs.getString(1) + " " + rs.getString(2));
		}
		
    
	}

}
