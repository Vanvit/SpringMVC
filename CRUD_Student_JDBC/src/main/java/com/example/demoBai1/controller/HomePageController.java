package com.example.demoBai1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

	
	@GetMapping(value={"/", "/homePage"})
	public String showHomePape() {
		return "homePage";
	}

}
