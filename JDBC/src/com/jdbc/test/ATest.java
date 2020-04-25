package com.jdbc.test;

public class ATest {

	public static void main(String[] args)  
	{
		A.test2();
		try {
			Class cls=Class.forName("com.jdbc.test.A");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
