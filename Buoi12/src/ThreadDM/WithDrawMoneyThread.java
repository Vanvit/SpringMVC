package ThreadDM;

public class WithDrawMoneyThread extends Thread{
	
	private BankAc bankAc;
	private Long withDrawMoney;
	public WithDrawMoneyThread(BankAc bankAc, Long withDrawMoney) {
		super();
		this.bankAc = bankAc;
		this.withDrawMoney = withDrawMoney;
	}
	
	@Override
	public void run() {
		bankAc.withDrawMoney(withDrawMoney);
		
	}

}
