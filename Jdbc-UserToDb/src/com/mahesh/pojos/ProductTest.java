package com.mahesh.pojos;

public class ProductTest {

	public static void main(String[] args) {
		Product product = new Product();
		/*
		 * product.id = 1; product.name = "mahesh"; System.out.println(product.id);
		 * System.out.println(product.name);
		 * 
		 */
		product.setId(1);
		product.setName("Mahesh");
		System.out.println(product.getId());
		System.out.println(product.getName());
		String string = product.toString();
		System.out.println(string);
	}
}