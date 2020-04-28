package com.mahesh.pojos;

public class Product {
// pojo = plane old java object..
	// changes happens oneclass  should not affected another class 
	// every property public 
	// pojos contain setters and getters method 
	
/*
 * public int id; public String productName;
 */
	
	private   int id;
	private   String productName;
	
	//setter mean setting values in to particular object..
	// getter mean getting data from particular object
	
 public void setId(int id) {
	 this.id=id;
 }
 public int getId() {
	 return id;
 }
 
 public void setName(String name) {
	 this.productName=name;
 }
  public String getName() {
	  return productName;
  }
 
 
 
 
 
 
 
}
