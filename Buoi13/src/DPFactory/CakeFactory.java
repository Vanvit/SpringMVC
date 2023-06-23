package DPFactory;

import DesignPatternSingleton.Printer;

public class CakeFactory {
	
	
	private static CakeFactory cF = null;
	private CakeFactory() {
		
	}
	public static CakeFactory getInstance() {
		if(cF == null ) {
			cF = new CakeFactory();
		}
		return cF;
	}
	
	
	public Cake getCake(String taste) {
		Cake cake = null;
		
		switch (taste) {
		case "Ngot":
			cake = new SugerCake();
			break;
		case "Dang":
			cake = new BitterCake();
			break;
		case "Cay":
			cake = new SpicyCake();
			break;
		default:
			throw new AssertionError("Khong co vi banh nay!!!");			
		}
		return cake;		
	}

}
