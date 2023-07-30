package com.example.demoBai1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demoBai1.Exception.AplicationException;
import com.example.demoBai1.Form.Student;
import com.example.demoBai1.Service.StudentService;

@Controller
public class CreateStudentController {
	
	@Autowired // lay ra tu thung chua IOC
	private StudentService studentService;
	
	@GetMapping("createStudent")
	public String showCreateStuddentPage(Model model) {
		model.addAttribute("form",new Student());
		return "showCreateStuddentPage";
	}

	@PostMapping("createStudent")
	public String createStuddentPage(@ModelAttribute Student student, Model model) {
		try {
			studentService.save(student);
			return "homePage";
		} catch (AplicationException e) {
			model.addAttribute("message",e.getMessage());
			model.addAttribute("form",student);
			return "showCreateStuddentPage";
		}
		

	}
}
