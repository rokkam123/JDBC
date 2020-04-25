package com.jdbc.test.Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TextFileToDatabaseDao {

	public void insertStudentDetails() {
		String url = "jdbc:mysql://localhost:3306/jdbc-mahesh";
		String userName = "root";
		String password = "root";
		int noOfRows = 0;
		try {
			FileReader fileReader = new FileReader("E:\\student.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while (line != null) {
				String[] values = line.split(",");
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url, userName, password);
				PreparedStatement prepareStatement = connection.prepareStatement("insert into student values(?,?,?,?)");
				prepareStatement.setString(1, values[0]);
				prepareStatement.setString(2, values[1]);
				prepareStatement.setString(3, values[2]);
				prepareStatement.setString(4, values[3]);
				int executeUpdate = prepareStatement.executeUpdate();
				if (executeUpdate != 0) {
					noOfRows++;
				}
				line = bufferedReader.readLine();
			}
			System.out.println("NO of Rows inserted : " + noOfRows);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
