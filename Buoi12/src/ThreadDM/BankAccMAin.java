package ThreadDM;

public class BankAccMAin {
	public static void main(String[] args) {
		BankAc bankacc = new BankAc(100L);
		Thread t1 = new WithDrawMoneyThread(bankacc,100L);
		Thread t2 = new WithDrawMoneyThread(bankacc,100L);
		Thread t3 = new WithDrawMoneyThread(bankacc,100L);
		Thread t4 = new WithDrawMoneyThread(bankacc,100L);
		Thread t5 = new WithDrawMoneyThread(bankacc,100L);
		Thread t6 = new WithDrawMoneyThread(bankacc,100L);
		Thread t7 = new WithDrawMoneyThread(bankacc,100L);
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		
	}

}
