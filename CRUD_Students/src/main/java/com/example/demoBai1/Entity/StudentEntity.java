package com.example.demoBai1.Entity;

public class StudentEntity {
	private Long id;
	private String name;
	private Integer age;
	private String DoB;
	private Float score;
	
	
	
	public StudentEntity() {
		super();
	}
	public StudentEntity(Long id, String name, Integer age, String doB, Float score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		DoB = doB;
		this.score = score;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDoB() {
		return DoB;
	}
	public void setDoB(String doB) {
		DoB = doB;
	}
	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", age=" + age + ", DoB=" + DoB + ", score=" + score
				+ "]";
	}
	
	
	

}
