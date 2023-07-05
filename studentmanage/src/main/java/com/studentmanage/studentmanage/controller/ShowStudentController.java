package com.studentmanage.studentmanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.studentmanage.studentmanage.model.StudentModel;
import com.studentmanage.studentmanage.service.StudentService;

@Controller
public class ShowStudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("showStudentsPage")
	public String showStudentsPage(Model model) {
		List<StudentModel> students = studentService.getStudents();
		model.addAttribute("students", students);
		return "showStudentsPage"; // Views templates
	}
	
}
