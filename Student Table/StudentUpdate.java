package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentUpdate {
	public static void main(String[]args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "root";
		String sql = "UPDATE student SET name='ABC', email='abc@mail.com' WHERE ID=3";
		
		
		
		//STEP 1: Load/Register the driver
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		//STEP 2: Establish Connection
		Connection connection = DriverManager.getConnection(url,username,password);
		
		//STEP 3: Establish Statement
		Statement statement = connection.createStatement();
		
		//STEP 4: Execute statement
		statement.execute(sql);
		
		//STEP 5: Close connection
		connection.close();
		System.out.println("ALL GOOD");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
