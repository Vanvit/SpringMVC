package com.example.demoBai1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demoBai1.Service.StudentService;


@Controller
public class DeleteStudentController {
	
	@Autowired // lay ra tu thung chua IOC
	private StudentService studentService;
	
	@DeleteMapping("students/{id}")
	public String deleteStudent(@PathVariable (name ="id") String id) {

		
		return "homePage";
	}
	

}
