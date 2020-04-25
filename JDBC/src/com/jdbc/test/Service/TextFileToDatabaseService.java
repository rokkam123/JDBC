package com.jdbc.test.Service;

import com.jdbc.test.Dao.TextFileToDatabaseDao;

public class TextFileToDatabaseService {
	static TextFileToDatabaseDao textFileToDatabaseDao =new TextFileToDatabaseDao();
	public void insertStudentDetails() {
		textFileToDatabaseDao.insertStudentDetails();
		
	}

}
