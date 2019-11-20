package br.com.age.challenge.struts.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.age.challenge.struts.exceptions.DBException;

public class DB {
	
	public static Connection connection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/age", "root", "root");
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
	}

}

