package com.example.demoBai1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demoBai1.Model.StudentModel;
import com.example.demoBai1.Service.StudentService;

@Controller
public class showStudentController {
	@Autowired // lay ra tu thung chua IOC
	private StudentService studentService;
	
	@GetMapping("showStudentPage")
	public String showStudentPage(Model model) {
		List<StudentModel> students =  studentService.getStudents();
		model.addAttribute("students", students);
		return "showStudentPage";
	}
}
