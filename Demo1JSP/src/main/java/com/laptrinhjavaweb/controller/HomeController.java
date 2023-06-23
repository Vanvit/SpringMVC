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
	  
/*	   @RequestMapping(value = "/springmvc", method = RequestMethod.GET)
	   public ModelAndView springMVCPage() {
	      ModelAndView mav = new ModelAndView("springmvc");
	      return mav;
	   }*/
	 
//	  @RequestMapping("/")
//	  public String index() {
//	    return "home";
//	  }
//	 @PostMapping("/login")
//	 public String login(HttpSession session,
//			 @RequestParam("username") String username,
//			 @RequestParam("password") String password) {
//		 if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
//			 session.setAttribute("username", username);
//				
//				return "redirect:/home";
//		}else {
//				return "redirect:/login";
//		}
//		 		
//		 
//	 }
	 
}
