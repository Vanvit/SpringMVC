package ThreadDM;

public class MyThread extends Thread{
	
	private String name;
	
	
	
	public MyThread(String name) {
		super();
		this.name = name;
	}



	@Override
	public void run() {

		
/*		try {
			Thread.sleep(3000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		System.out.println("Id Thread la: " + getId());
		System.out.println(getName() + " Thread is running!!!");
	}

}
