package B13;

public class MainStudent {
	public static void main(String[] args) {
		Student st = new Student("Minh");
		StudentPrinter<Student> sP = new StudentPrinter<Student>(st);
		
		sP.print();
	}

}
