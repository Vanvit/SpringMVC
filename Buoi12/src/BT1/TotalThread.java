package BT1;

public class TotalThread extends Thread{
	private Integer endNumber;
	private Integer startNumber;	
	private Integer result;

	public TotalThread( Integer startNumber, Integer endNumber) {
		super();
		this.endNumber = endNumber;
		this.startNumber = startNumber;
	}

	@Override
	public void run() {
		Integer result  = 0;
		for (int i = startNumber; i <= endNumber; i++) {
			result += i;
		}
		this.result = result;
	}


	public Integer getResult() {
		return result;
	}

}
