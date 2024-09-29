package com.spring.jdbc.spingjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMySQLConnection {

	public static void main(String[] args) throws ClassNotFoundException {
		Connection conn = null;
		
		try {
			System.out.println("Going for MYSQL123");
		    conn =
		       DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/springjdbc?user=root&password=Dipti123@MYSQL");
		    System.out.println("Connection successful");
		  
		} catch (SQLException ex) {
	        System.out.println(ex);
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
