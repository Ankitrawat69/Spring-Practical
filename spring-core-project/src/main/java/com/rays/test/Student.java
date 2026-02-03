package com.rays.test;

public class Student {
	
	private String name;
	private String address;
	private String rollno;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public Student(String name, String address, String rollno) {
		
		this.name = name;
		this.address = address;
		this.rollno = rollno;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
}
