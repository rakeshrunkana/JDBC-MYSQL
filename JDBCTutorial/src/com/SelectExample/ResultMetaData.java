package com.SelectExample;

import java.sql.*;

public class ResultMetaData {

	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";

	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		PreparedStatement stmt = con.prepareStatement("Select* from Employees");
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();

		System.out.println("Total columns " + rsmd.getColumnCount());
		System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
		System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));
		con.close();
	}

}
