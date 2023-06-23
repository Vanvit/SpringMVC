package WaitAndNotify;

import java.util.Random;

public class Thread1 extends Thread{
	private ShareData data;

	public Thread1(ShareData data) {
		super();
		this.data = data;
	}
	
	@Override
	public void run() {
		for(int i =0; i<10; i++) {	
			synchronized (data) {
				try {
					if (i != 0) {
						data.wait();
					}				
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
			Random random = new Random();
			int newCount = random.nextInt(10);
			data.setCount(newCount);
			
			System.out.println("T1>: " + data.getCount());
			
			synchronized(data) {
				data.notifyAll();
			}
		}
	}

}
