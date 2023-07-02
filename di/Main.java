package com.minhnc.springboottutorial.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
	
	@Autowired
	private StudentService studentService;
	
	// http://localhost:8080/test
	@GetMapping("/test")
	public void test() {
		studentService.saveStudent();
	}
	
}
