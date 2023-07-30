package com.example.demoBai1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demoBai1.Exception.AplicationException;
import com.example.demoBai1.Service.StudentService;


@Controller
public class DeleteStudentController {
	
	@Autowired // lay ra tu thung chua IOC
	private StudentService studentService;
	
	@RequestMapping(value = "deleteStudent/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable (name ="id") String id,Model model) {

		try {
			studentService.deleteStudentById(id);
			return "homePage";
		} catch (AplicationException e) {
			model.addAttribute("message", e.getMessage());
			return "notfoundpage";
		}
	}
}
