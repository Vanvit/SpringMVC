package com.example.demoBai1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoBai1Application {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(DemoBai1Application.class, args);
		
		GirlFriend girlFriend = ((BeanFactory) context).getBean(GirlFriend.class);
		
		System.out.println("Girlfriend: "+girlFriend);
		System.out.println("Outfit of Girlfriend: "+girlFriend.outfit);
		girlFriend.outfit.wear();
	}

}
