package com.SelectExample;

import java.sql.*;

public class UpdateQuery {

	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		System.out.println("Connected to the Database! ");
		Statement stmt = con.createStatement();
		String sql = "UPDATE Registration " + "SET age =30 WHERE id in (100,101)";
		stmt.executeUpdate(sql);
		System.out.println("Updated Table:");
		ResultSet rs = stmt.executeQuery("Select* from Registration");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));

		}

	}

}
