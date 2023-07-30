package com.example.jdbcExample.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbcExample.entity.UserEntity;

@RestController
@RequestMapping("api/v1/roles")
public class UserV1Api {
	
	public UserEntity getUserName() {
		UserEntity userEntity = new UserEntity();

		return userEntity;
	}

}
