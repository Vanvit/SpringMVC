package WaitAndNotify;

public class Thread2 extends Thread{
	
	private ShareData data;

	public Thread2(ShareData data) {
		super();
		this.data = data;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			
			synchronized (data) {
				try {
					data.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
			
			Integer count = data.getCount();
			System.out.println("T2: " + (count*count));
			synchronized (data) {
				data.notifyAll();
				
			}
			
		}
	}

}
