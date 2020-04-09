package com.review3.Encapsulation;

public class Student {
	private String name;
	private String password;
	private int age;
	private String SSN;

	public String getProperty(String key) {
		if (key.equals("name")) {
			return name;
		} else if (key.equals("password")) {
			return password;
		} else if (key.equals("SSN")) {
			return "No I am not giving it to you :) ";
		}
		return "";
	}

	public String getSSN() {
		return SSN.substring(6);
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getName(String password) {
		if (password.equals(this.password)) {
			return name;
		} else {
			return "You cannot access the name. Wrong password!!!";
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password.length() > 6)
			this.password = password;
	}

	public int getAge() {
		return age / 2;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
