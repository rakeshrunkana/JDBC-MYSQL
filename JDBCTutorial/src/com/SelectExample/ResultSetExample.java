package com.SelectExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetExample {

	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";
	static final String QUERY = "SELECT id, first, last, age FROM Employees";

	public static void main(String[] args) {
		// Open a connection

		try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(QUERY);) {
			// Move cursor to the last row.
			System.out.println("Moving cursor to the last...");
			rs.last();
			// Extract data from result set
			System.out.println("Displyaing record...");
			// Retrive by column name
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			String first = rs.getString("first");
			String last = rs.getString("last");

			// Display values
			System.out.print("ID: " + id);
			System.out.print(", Age: " + age);
			System.out.print(", First: " + first);
			System.out.println(", Last: " + last);

			// Move cursor to the third row.
			System.out.println("Moving cursor to the 2nd row...");
			rs.absolute(2);
			// Extract data from result set
			System.out.println("Displaying record of 2nd row...");
			// Retrive by column name
			int id1 = rs.getInt("id");
			int age1 = rs.getInt("age");
			String first1 = rs.getString("first");
			String last1 = rs.getString("last");
			// Display values
			System.out.print("ID: " + id1);
			System.out.print(", Age: " + age1);
			System.out.print(", First: " + first1);
			System.out.println(", Last: " + last1);

			// Move cursor to the first row.
			System.out.println("Moving cursor to the first row...");
			rs.first();

			// Extract data from result set
			System.out.println("Displaying record...");
			// Retrieve by column name
			id1 = rs.getInt("id");
			age1 = rs.getInt("age");
			first1 = rs.getString("first");
			last1 = rs.getString("last");
			// Display values
			System.out.print("ID: " + id1);
			System.out.print(", Age: " + age1);
			System.out.print(", First: " + first1);
			System.out.println(", Last: " + last1);
			// Move cursor to the first row.

			System.out.println("Moving cursor to the next row...");
			rs.next();

			// Extract data from result set
			System.out.println("Displaying record...");
			id1 = rs.getInt("id");
			age1 = rs.getInt("age");
			first1 = rs.getString("first");
			last1 = rs.getString("last");

			// Display values
			System.out.print("ID: " + id1);
			System.out.print(", Age: " + age1);
			System.out.print(", First: " + first1);
			System.out.println(", Last: " + last1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
