package com.SelectExample;

import java.sql.*;

public class InsertingRecords {

	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		Statement stmt = con.createStatement();
		// Execute a query
		System.out.println("Inserting records into the table...");
		/*String sql = "INSERT INTO Registration VALUES (100,'Zara', 'Ali', 18)";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO Registration VALUES (101, 'Mahnaz', 'Fatma', 25)";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO Registration VALUES (102, 'Zaid', 'Khan', 30)";
		stmt.executeUpdate(sql);
		sql = "INSERT INTO Registration VALUES(103, 'Sumit', 'Mittal', 28)";
		stmt.executeUpdate(sql);*/
		ResultSet rs = stmt.executeQuery("Select* from Registration");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4));
		}
		System.out.println("Inserted records into the table...");
	}

}
