package com.example.demoBai1.Form;

public class Student {

	private String name = "";
	private String age = "";
	private String DoB = "";
	private String score = "";

	public Student() {
		super();
	}

	public Student(String name, String age, String doB, String score) {
		super();

		this.name = name;
		this.age = age;
		DoB = doB;
		this.score = score;
	}

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

	public String getDoB() {
		return DoB;
	}

	public void setDoB(String doB) {
		DoB = doB;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", DoB=" + DoB + ", score=" + score + "]";
	}

}
