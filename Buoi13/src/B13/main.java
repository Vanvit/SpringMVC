package B13;

public class main {
	public static void main(String[] args) {
		IntegerPrinter p = new IntegerPrinter(30);
		p.print();
		
		StringPrinter str = new StringPrinter("Van xinh gai");
		str.print();
		
//		Printer<Integer> interPrinter = new Printer<Integer>(300);
//		interPrinter.print();
//		
//		Printer<String> StringPrinter = new Printer<String>("Van 2");
//		StringPrinter.print();
		
		Printer<Integer, String> interPrinter = new Printer<Integer, String>(300, "Helllo Van!!!");
		interPrinter.print();

		
	}

}
