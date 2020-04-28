package com.mahesh.Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserToDatabase {
	public static void main(String[] args) {
		while (true) {
			System.out.println("Please select option ");
			Scanner sca = new Scanner(System.in);
			System.out.println("1.Insert ");
			System.out.println("2.upadate");
			System.out.println("3.delete");
			System.out.println("4.getbyId");
			System.out.println("5.getAll");
			System.out.println("6.Exit");
			int option = Integer.parseInt(sca.nextLine());
			System.out.println(option);
			switch (option) {
			case 1:
				System.out.println("Insert logic  Executed");
				insertStudent();
				break;
			case 2:
				System.out.println("update logic  Executed");
				updateStudent();
				break;
			case 3:
				System.out.println("Delete logic  Executed");
				deleteStudent();
				break;
			case 4:
				System.out.println("GetByID logic  Executed");
				getById();
				break;
			case 5:
				System.out.println("GetAll logic  Executed");
				getAll();
				break;
			case 6:
				System.out.println("Successfully Exited");
				System.exit(0);
			}
		}
	}

	public static void getAll() {
	  Connection connection =GetJdbcConnection.getConnection(); 
	  try {
		PreparedStatement preparestatemnt = connection.prepareStatement("select * from student ");
		ResultSet rs = preparestatemnt.executeQuery();
		while(rs.next()) {
			int studentId = rs.getInt("id");
			String studentFirstName = rs.getString("first_Name");
			String studentLastName = rs.getString("last_Name");
			String emailid = rs.getString("emailId");
			System.out.println(studentId);
			System.out.println(studentFirstName);
			System.out.println(studentLastName);
			System.out.println(emailid);
			System.out.println("==================");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	public static void getById() { 
		  Scanner scanner2 = new Scanner(System.in);
			System.out.println("Please Enter Id");
			int id = Integer.parseInt(scanner2.nextLine());
	  Connection connection =GetJdbcConnection.getConnection(); 
	  try {
		PreparedStatement preparestatemnt = connection.prepareStatement("select * from student where id=?");
		preparestatemnt.setInt(1, id);
		ResultSet rs = preparestatemnt.executeQuery();
		if(rs.next()) {
			int studentId = rs.getInt("id");
			String studentFirstName = rs.getString("first_Name");
			String studentLastName = rs.getString("last_Name");
			String emailid = rs.getString("emailId");
			System.out.println(studentId);
			System.out.println(studentFirstName);
			System.out.println(studentLastName);
			System.out.println(emailid);
			System.out.println("==================");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  }

	public static void deleteStudent() {
		Scanner scanner3 = new Scanner(System.in);
		System.out.println("Please Enter Id");
		int id = Integer.parseInt(scanner3.nextLine());
		Connection connection = GetJdbcConnection.getConnection();
		try {
			PreparedStatement ps2 = connection.prepareStatement("delete from student where id = ?");
			ps2.setInt(1, id);
			ps2.executeUpdate();
			System.out.println("data sucessfully deleted");
			System.out.println("===================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void updateStudent() {
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Please Enter Id");
		int id = Integer.parseInt(scanner1.nextLine());
		System.out.println("please Enter LastName");
		String lastname = scanner1.nextLine();
		Connection connection = GetJdbcConnection.getConnection();
		try {
			PreparedStatement ps1 = connection.prepareStatement("update student set last_Name =?  where id =? ");
			ps1.setString(1, lastname);
			ps1.setInt(2, id);
			ps1.executeUpdate();
			System.out.println("updated sucessfully");
			System.out.println("================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertStudent() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter Student First ");
		String firstName = scanner.nextLine();
		System.out.println("Please Enter Student Last Name");
		String lastName = scanner.nextLine();
		System.out.println("Please Enter Student Email ID");
		String emailID = scanner.nextLine();
		Connection connection = GetJdbcConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into student(first_name,last_name,emailId) values (?,?,?)");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, emailID);
			ps.addBatch();
			
			ps.executeUpdate();
			System.out.println("Insert Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
