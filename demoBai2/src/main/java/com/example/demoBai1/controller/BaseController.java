package com.example.demoBai1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

//	@RequestMapping(value = { "/hekko" }, method = RequestMethod.GET)
//	public String welcome() {
//		User user = new User(1, "Vân");
//		return user.toString();
//	}
	@RequestMapping(value = { "/hekko" }, method = RequestMethod.GET)
	public ResponseEntity<String> welcome() {
		User user = new User(1, "Vân");
		return new ResponseEntity<>(user.toString(), HttpStatus.NOT_FOUND);
	}

}
