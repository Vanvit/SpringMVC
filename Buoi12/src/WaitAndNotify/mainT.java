package WaitAndNotify;

public class mainT {
	
	public static void main(String[] args) {
		ShareData data = new ShareData();
		
		Thread1 thread1 = new Thread1(data); // Gui Data
		Thread2 thread2 = new Thread2(data); // Nhan Data
		
		thread1.start();
		thread2.start();
		
	}

}
