package com.jdbc.test.Controller;

import com.jdbc.test.Service.TextFileToDatabaseService;

public class TextFileToDatabaseController {
	static TextFileToDatabaseService textFileToDatabaseService=new TextFileToDatabaseService();
	
	public static void main(String[] args) {
		textFileToDatabaseService.insertStudentDetails();
	}
}
