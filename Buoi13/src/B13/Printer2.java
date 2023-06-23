package B13;

public class Printer2 <T>{


	private T student;
	

	public Printer2(T student) {
		this.student = student;
	}

	public T getStudent() {
		return student;
	}

	public void setStudent(T student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentPrinter [student=" + student + "]";
	}
	public void print() {
		System.out.println(student);
	}

	

}
