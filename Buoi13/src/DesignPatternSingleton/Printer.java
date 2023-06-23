package DesignPatternSingleton;

public class Printer {
	
//	private static Printer printer = new Printer();
	private static Printer printer = null;
	
	// k cho tao doi tuong moi
	private Printer() {
		
	}
	
	// goi ra dc
	public static Printer getInstance() {
		if(printer == null ) {
			printer = new Printer();
		}
		return printer;
	}


	public void print(Student student) {
		System.out.println(student);
	}

}
