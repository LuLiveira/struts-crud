package br.com.age.challenge.struts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	public static Connection connection() throws ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/age", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

