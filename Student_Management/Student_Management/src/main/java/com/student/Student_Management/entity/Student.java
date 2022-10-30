package com.student.Student_Management.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Student {
	
	
	@Id
	private long roll;
	private String first_name;
	private String last_name;
	private int age;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long roll, String first_name, String last_name, int age) {
		super();
		this.roll = roll;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}
	public long getRoll() {
		return roll;
	}
	public void setRoll(long roll) {
		this.roll = roll;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age
				+ "]";
	}
	
	

}
