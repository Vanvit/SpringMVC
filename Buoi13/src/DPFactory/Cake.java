package DPFactory;

public class Cake {
	
	private String name;
	private String taste;
	public Cake(String taste) {
		super();
		this.taste = taste;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	@Override
	public String toString() {
		return "Cake [taste=" + taste + "]";
	}
	
	
	

}
