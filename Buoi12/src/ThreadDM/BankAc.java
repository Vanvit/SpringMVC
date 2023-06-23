package ThreadDM;

public class BankAc {
	
	private Long money;

	public BankAc(Long money) {
		super();
		this.money = money;
	}
	public synchronized void withDrawMoney(Long withDrawMoney) {
			money = money - withDrawMoney;
			System.out.println(this);
	}
	@Override
	public String toString() {
		return "BankAc [money=" + money + "]";
	}
	public void println() {
		
	}
	

}
