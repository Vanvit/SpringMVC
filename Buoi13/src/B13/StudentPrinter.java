package B13;

public class StudentPrinter<T extends Student>{
	
	private T student;
	

	public StudentPrinter(T student) {
		super();
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
