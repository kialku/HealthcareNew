package com.spring.healthcare.util;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DBManager {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/healthcare";

	private static final String USER_NAME = "root";

	private static final String PASSWORD = "root";

	private Connection connection = null;

	private static final DBManager THIS = new DBManager();

	private DBManager(){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);  
		}catch(Exception e){ 

		}  
	}  
	public static DBManager getInstance(){
		return THIS;
	}

	public Connection  getConnection(){
		return connection;
	}
}
