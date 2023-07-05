package com.studentmanage.studentmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanage.studentmanage.exception.ApplicationException;
import com.studentmanage.studentmanage.form.CreateStudentForm;
import com.studentmanage.studentmanage.service.StudentService;

@Controller
public class CreateStudentController {

	@Autowired
	private StudentService studentService;

	// http://localhost:8080/createStudent
	@GetMapping("createStudent")
	public String showCreateStudentPage(Model model) {
		model.addAttribute("form", new CreateStudentForm());
		return "createStudentPage";
	}

	@PostMapping("createStudent")
	public String createStudent(@ModelAttribute CreateStudentForm form, Model model) {
		try {
			studentService.save(form);
			return "homePage";
		} catch (ApplicationException e) {
			model.addAttribute("message", e.getMessage());
			model.addAttribute("form", form);
			return "createStudentPage";
		}
	}

}
