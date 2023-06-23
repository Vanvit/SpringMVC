package com.laptrinhjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	   public ModelAndView homePage() {
	      ModelAndView mav = new ModelAndView("login");
	      return mav;
	   }
//	  
//	 @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
//	   public ModelAndView homePage2() {
//	      ModelAndView mav2 = new ModelAndView("xuLyDangNhap");
//	      return mav2;
//	   }
}
