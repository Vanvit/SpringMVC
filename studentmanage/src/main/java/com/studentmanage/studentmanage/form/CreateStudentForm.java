package com.studentmanage.studentmanage.form;

public class CreateStudentForm {
	
	private String name = "";
	
	private String age = "";
	
	private String dateOfBirth = "";
	
	private String score = "";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "CreateStudentForm [name=" + name + ", age=" + age + ", dateOfBirth=" + dateOfBirth + ", score=" + score
				+ "]";
	}
	
	
}
