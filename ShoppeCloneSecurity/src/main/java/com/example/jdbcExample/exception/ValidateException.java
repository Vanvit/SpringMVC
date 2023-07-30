package com.example.jdbcExample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//http statusCode
//200 -> OK
//404 -> Not found
// 400 -> Validate
//500 -> Logic

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ValidateException extends AplicationException{

	public ValidateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
