package DPFactory;

import java.util.Scanner;

public class mainFactory {
	// nhap tu ban phim va tao ra banh co vi tuong tu
	// in ra man hinh

	public static void main(String[] args) {
//		Cake sC = new SugerCake();
//		Cake bC = new BitterCake();
//		Cake spC = new SpicyCake();
//		
//		System.out.println(sC);
//		System.out.println(bC);
//		System.out.println(spC);
		
		
		Scanner scanner =  new Scanner(System.in);
		System.out.println("Nhap vi banh: ");
		String taste = scanner.nextLine();
		
//		CakeFactory cakeFactory = CakeFactory.getInstance();
//		Cake c = cakeFactory.getCake(taste);
		
		// Bien CakeFactory thanh 1 singleton class
		Cake c = CakeFactory.getInstance().getCake(taste);

		System.out.println("VI BANH NAY la: " +c);
		
		// Bien CakeFactory thanh 1 singleton class
		
		
		
		
	}
	
}
