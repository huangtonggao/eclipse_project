package com.example.bundletest;

import java.io.Serializable;

public class Person implements Serializable {
	
	private String name;
	private String password;
	private String gender;
	
	public Person(String name, String password, String gender) {
		super();
		this.name = name;
		this.password = password;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
