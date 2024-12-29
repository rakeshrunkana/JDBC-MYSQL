package com.SelectExample;

import java.sql.*;

public class WhereClause {

	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";
	static final String QUERY = "SELECT id, first, last, age FROM Registration";

	public static void main(String[] args) {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				Statement stmt = conn.createStatement();) {
			System.out.println("Fetching records without condition...");
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				// Display values
				System.out.print("ID: " + rs.getInt("id"));
				System.out.print(", Age: " + rs.getInt("age"));
				System.out.print(", First: " + rs.getString("first"));
				System.out.println(", Last: " + rs.getString("last"));
			}

			// Select all records having ID equal or greater than 101
			System.out.println("Fetching records with condition...");
			String sql = "SELECT id, first, last, age FROM Registration" + " WHERE id >= 101 ";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Display values
				System.out.print("ID: " + rs.getInt("id"));
				System.out.print(", Age: " + rs.getInt("age"));
				System.out.print(", First: " + rs.getString("first"));
				System.out.println(", Last: " + rs.getString("last"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
