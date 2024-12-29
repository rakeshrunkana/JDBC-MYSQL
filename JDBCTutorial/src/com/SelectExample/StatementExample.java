package com.SelectExample;

import java.sql.*;

public class StatementExample {
	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";
	static final String QUERY = "SELECT id, first, last, age FROM Employees";
	static final String UPDATE_QUERY = "UPDATE Employees set age=30 where id =103";

	public static void main(String[] args) {
		// Open connection
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				Statement stmt = conn.createStatement();) {
			// Let us check if it returns a true Result Set or not.
			Boolean ret = stmt.execute(UPDATE_QUERY);
			System.out.println("Return value is " + ret.toString());
			// Let us update age of the record with ID = 103;
			int rows = stmt.executeUpdate(UPDATE_QUERY);
			System.out.println("Rows Impacted : " + rows);
			// Let us select all the records and display them.
			ResultSet rs = stmt.executeQuery(QUERY);
			// Extract data from result set
			while (rs.next()) {
				// Retrive by coulmn name
				System.out.println("ID " + rs.getInt("id"));
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
