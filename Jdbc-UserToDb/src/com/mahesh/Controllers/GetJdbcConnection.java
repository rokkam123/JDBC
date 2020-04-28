package com.mahesh.Controllers;

	import java.sql.Connection;
import java.sql.DriverManager;

public class GetJdbcConnection {
	
	public  static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/jdbc-mahesh";
		String name = "root";
		String pass = "root";
		Connection connection=null ;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection= DriverManager.getConnection(url,name,pass);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	}
	
	
