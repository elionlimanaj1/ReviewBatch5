package com.review3.Encapsulation;

public class School {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("John");
		s1.setAge(30);
		s1.setPassword("123456");
		s1.setSSN("1234567890");

		// using getters and setters
		String name = s1.getName("1234");
		System.out.println(name);

		name = s1.getName("123456");
		System.out.println("Name is " + name);

		System.out.println("Age is " + s1.getAge());

		System.out.println("SSN is " + s1.getSSN());
	}
}
