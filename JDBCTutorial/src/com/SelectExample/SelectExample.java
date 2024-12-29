package com.SelectExample;

import java.sql.*;

public class SelectExample {
	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";
	static final String QUERY = "SELECT id, first, last, age FROM Employees";

	public static void main(String[] args) {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
			// Extract data from result set
			while (rs.next()) {
				// Retrive by column name
				System.out.println("ID: " + rs.getInt("id"));
				System.out.print(", Age: " + rs.getInt("age"));
				System.out.print(", First: " + rs.getString("first"));
				System.out.println(", Last: " + rs.getString("last"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
