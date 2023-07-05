package com.studentmanage.studentmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.studentmanage.studentmanage.exception.ApplicationException;
import com.studentmanage.studentmanage.service.StudentService;

@Controller
public class DeleteStudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("deleteStudent/{id}")
	public String deleteStudent(@PathVariable(name = "id") String id, Model model) {
		try {
			studentService.deteleStudentById(id);
			return "homePage";
		} catch (ApplicationException e) {
			model.addAttribute("message", e.getMessage());
			return "notfoundpage";
		}
		
	}
	
}
