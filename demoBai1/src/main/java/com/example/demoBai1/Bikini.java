package com.example.demoBai1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // cach1
public class Bikini implements Outfit{

	@Override
	public void wear() {
		System.out.println("Đang mặc Bikini!!!!");
		
	}

}
