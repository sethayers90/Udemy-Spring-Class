package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcurl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		String user = "root";
		String pass = "password";
		
		try {
			System.out.println("Connecting to database"+jdbcurl);
			Connection myConn =
					DriverManager.getConnection(jdbcurl,user,pass);
			System.out.println("Connection successful");
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
