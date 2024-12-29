package com.SelectExample;

import java.sql.*;

public class SelectDatabase {

	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		System.out.println("Connected database successfully...");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SHOW DATABASES");
		System.out.println("DATABASES");
		System.out.println("---------------------");
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("----------------------");
		// The line below SELECTS a database world
		stmt.executeUpdate("use world");
		ResultSet rs2=stmt.executeQuery("SHOW TABLES");
		System.out.println("Tables in WORLD ");
		while(rs2.next()) {
			System.out.println(rs2.getString(1));
		}
		System.out.println("-----------------------");
		ResultSet rs1 = stmt.executeQuery("select* from countrylanguage");
		while(rs1.next()) {
		System.out.println(rs1.getString(1) + " " + rs1.getString(2) + " " + rs1.getString(3) + " " + rs1.getString(4));
	}
	}

}
