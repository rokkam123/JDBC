package com.jdbc.test;

public class A {
	public A() {
		System.out.println("default constructor");
	}

	public A(int id) {
		this.id = id;
		System.out.println("parameterized  constructor");
	}

	private int id;// property

	public void test1() {
		System.out.println("tanoj ");
	}

	{
		System.out.println("Instance Block");
	}
	static {
		System.out.println("Static Block");
	}

	public static int test2() {
		System.out.println("Static method");
		return 10;
	}

		
	
}
