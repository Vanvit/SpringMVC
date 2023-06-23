package B13;

import java.util.ArrayList;
import java.util.List;

public class MainParttimeStudent {
	
	public static void main(String[] args) {
		
//		ParttimeStudent pt = new ParttimeStudent("Hoang", 30);
//		
//		StudentPrinter<Student> stS = new StudentPrinter<Student>(pt);
//		stS.print();
		
		print(20);
		Student st = new Student("Minh222");
		print(st);
		

		// wildcard 
		Student stt = new Student("Minh 333");
		Printer2<? extends Student> p = new Printer2<>(stt);
		p.print();
		
		
		// uu diem Generic...
		List/*<Integer>*/ list = new ArrayList<>();
		list.add(30000);
		list.add("Hello");
		
		Integer i = (Integer) list.get(0); // ep kieu
		
		System.out.println(i);
		

	}
	//  no using Generic  method - ham sd method
	private static void print(Integer integer) {
		System.out.println(integer);
	}
	// Generic  method - ham sd method
	private static <T extends Student> void print(T data) {
		System.out.println(data);
	}
	


}
