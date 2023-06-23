package B13;

public class Printer<T,E> {
	private T data;
	private E data2;
	
	public Printer(T data, E data2) {
		super();
		this.data = data;
		this.data2 = data2;
	}

	public void print() {
		System.out.println(data);
		System.out.println(data2);
	}

}
