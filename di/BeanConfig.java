package com.minhnc.springboottutorial.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Java
//@Configuration
public class BeanConfig {
	
	@Bean
	public StudentDao studentDao() {
		return new DatabaseStudentDao();
	}

	@Bean
	public StudentService studentService(StudentDao studentDao) {
		StudentService studentService = new StudentService();
//		studentService.setStudentDao(studentDao);
		return studentService;
	}
	
}
