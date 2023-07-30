package com.example.jdbcExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jdbcExample.entities.Customer;
import com.example.jdbcExample.entities.KhachHang;
import com.example.jdbcExample.repository.KhachHangRepository;

@Controller
@RequestMapping("test")
public class TestController {

	  @Autowired
	  private KhachHangRepository customerRepository;
	  
	  @GetMapping("1")
	  public String insertCustomer(Model model) {
	    model.addAttribute("customer", new Customer());
	    return "register2";
	  }
	  @PostMapping("/dang-ky2")
	  public String doSaveCustomer(@ModelAttribute("CustomerTrungGian") Customer customer, Model model) {
		  customerRepository.save(customer);
	    model.addAttribute("customer", customerRepository.findAll());
	    return "customer-view";
	  }

}
