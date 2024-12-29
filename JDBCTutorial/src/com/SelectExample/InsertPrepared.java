package com.SelectExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertPrepared {

	static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
	static final String USER = "root";
	static final String PASSWORD = "Rakesh@8280";

	public static void main(String args[]) throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		Statement stmt = con.createStatement();
        PreparedStatement stmt1 = con.prepareStatement("insert into Employees values(?,?,?,?)");
		stmt1.setInt(1, 105);
		stmt1.setInt(2, 22);
		stmt1.setString(3, "Rakesh");
		stmt1.setString(4, "Runkana");

		int i = stmt1.executeUpdate();
		System.out.println(i + " records inserted ");

		ResultSet rs = stmt.executeQuery("Select* from employees");
		while (rs.next())
			System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getString(3) + " " + rs.getString(4));
		con.close();

	}

}
