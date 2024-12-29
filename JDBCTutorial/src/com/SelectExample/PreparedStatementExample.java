package com.SelectExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {

	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";
	static final String QUERY = "SELECT id, first, last, age FROM Employees";
	static final String UPDATE_QUERY = "UPDATE Employees set age=? where id =?";

	public static void main(String[] args) {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY);) {

			// Bind values into the parameters.
			stmt.setInt(1, 35); // This would set age
			stmt.setInt(2, 102); // This would set ID

			// Let us update age of the record with ID = 102;
			int rows = stmt.executeUpdate();
			System.out.println("Rows impacted : " + rows);

			// Let us select all the records and display them.
			ResultSet rs = stmt.executeQuery(QUERY);

			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
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
