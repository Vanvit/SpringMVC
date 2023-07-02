package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping(path="/")
	public String hello(
			// lay du lieu tu URL
			@RequestParam(value="name") String name,
			@RequestParam(value="age") Integer age,
			Model model
			) {
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		
		System.out.println(name); // @RequestParam
		System.out.println(age); // @RequestParam
		
		// tra ve View  -> html file
//		model.addAttribute("name", name);
//		model.addAttribute("age", age);
		
		model.addAttribute("per", p); // show ra DL 
		return "hello";
	}
	
	
	@RequestMapping(path="/createPerson", method = RequestMethod.GET)
	public String create() {
		return "createPerson";
	}
	//Model Attribute truyen DL qua Body
	@RequestMapping(path="/createPerson", method = RequestMethod.POST)
	public String postPerson(@ModelAttribute(name="per") Person person) {

		System.out.println(person);
		
		return "hello";
	}
	
	
	

	
	
}
