package DesignPatternSingleton;

public class MainSingleton {
	public static void main(String[] args) {
		Student st= new Student("Minh 1234");
		
		Printer p = Printer.getInstance();
		p.print(st);
	}

}
