package com.example.demoBai1;

import org.springframework.stereotype.Component;

@Component
public class Dress implements Outfit{

	@Override
	public void wear() {
		System.out.println("Đang mặ váy!!!");
		
	}

}
