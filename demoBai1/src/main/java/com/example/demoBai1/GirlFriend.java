package com.example.demoBai1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class GirlFriend {
	@Autowired
	@Qualifier("dress") // cach2
	public Outfit outfit;

	public GirlFriend() {
		super();
	}

	public GirlFriend(Outfit outfit) {
		super();
		this.outfit = outfit;
	}

	@Override
	public String toString() {
		return "GirlFriend [outfit=" + outfit + "]";
	}

	public Outfit getOutfit() {
		return outfit;
	}

	public void setOutfit(Outfit outfit) {
		this.outfit = outfit;
	}

}
