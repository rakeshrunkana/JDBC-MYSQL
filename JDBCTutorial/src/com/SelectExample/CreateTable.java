package com.SelectExample;

import java.sql.*;

public class CreateTable {

	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		System.out.println("Database connected!");
		Statement stmt = con.createStatement();
		String sql = "CREATE TABLE REGISTRATION " + "(id INTEGER not NULL, " + "first VARCHAR(255), "
				+ " last VARCHAR(255), " + " age INTEGER, " + "PRIMARY KEY(id))";
		stmt.executeUpdate(sql);
		System.out.println("Created table in givem database...");
		con.close();
	}

}
