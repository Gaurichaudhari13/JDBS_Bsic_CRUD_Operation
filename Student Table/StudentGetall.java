package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentGetall {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "root";
		Connection connection = null;
		String sql = "SELECT * FROM student";

		// STEP 1: Load/Register the driver

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// STEP 2: Establish Connection
			connection = DriverManager.getConnection(url, username, password);

			// STEP 3: Establish Statement
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println("==================");

			}

			// STEP 4: Execute statement
			// statement.execute(sql);

			// STEP 5: Close connection
			// connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				System.out.println("GOOD");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
