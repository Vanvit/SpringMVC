package com.example.demoBai1.controller;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User {

	private Integer id;
	private String name;
		
	public User() {
		super();
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
