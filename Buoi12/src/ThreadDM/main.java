package ThreadDM;

public class main {
	public static void main(String[] args) {
		Thread thread1 = new MyThread("thread1");
		Thread thread2 = new MyThread("thread2");
		
		thread1.start();
		thread2.start();
		System.out.println("Main Thread is running!!");
	}

}
