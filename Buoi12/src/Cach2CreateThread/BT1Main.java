package Cach2CreateThread;

public class BT1Main {
	public static void main(String[] args) {
		T1 t1= new T1();
		T1 t2= new T1();
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Main running!!!");
	}
	

}
