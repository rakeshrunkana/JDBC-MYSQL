package com.SelectExample;

import java.sql.*;

public class CreateDatabase {

	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";

	public static void main(String[] args) throws Exception {
		// Open a connection
		Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		Statement stmt = con.createStatement();
		String sql = "CREATE DATABASE STUDENTS";
		stmt.executeUpdate(sql);
		System.out.println("Database created successfully...");
	}

}
