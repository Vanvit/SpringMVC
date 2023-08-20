package com.example.jdbcExample.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("login")
	public String login(@RequestParam(value="error", defaultValue= "false") Boolean error,
			@RequestParam(value="message",required = false ) String message,
			Model model
			) {
		model.addAttribute("error",error);
		model.addAttribute("message",message);
		
//		SecurityContext context = SecurityContextHolder.getContext();
		
		return "login";
	}
}
