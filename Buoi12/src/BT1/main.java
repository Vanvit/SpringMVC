package BT1;

import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

public class main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap n: ");
		String nStr = scanner.nextLine();
		Integer n;
		
		try {
			n= Integer.valueOf(nStr);
			
		} catch (Exception e) {
			System.err.println("Nhap so!!");
			return;
		}
		// 2 thread chia doi n moi Thread tinh 1 nua?
	
		Integer n1= n/2;
		Integer n2 = n -n1;
		if(!isOdd(n)) {
			n2 = (n2+1);
		}
		
		TotalThread t1 = new TotalThread(1, n1);
		TotalThread t2 = new TotalThread(n2, n);
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			System.err.println("Loi xay ra!");
			return;
		}
		
		Integer result = t1.getResult() + t2.getResult();
		System.out.println(t1.getResult());
		System.out.println("KQ: "+result);
		System.out.println("KQ: "+result);

		
	}
	private static boolean isOdd(Integer n) {
		return (n%2) == 1;
	}
	

}
