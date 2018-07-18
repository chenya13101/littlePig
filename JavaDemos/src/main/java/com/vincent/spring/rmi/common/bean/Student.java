package com.vincent.spring.rmi.common.bean;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 4619918279361369873L;
	private int id;
	private String name;

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getId() + " - " + this.getName();
	}

}
