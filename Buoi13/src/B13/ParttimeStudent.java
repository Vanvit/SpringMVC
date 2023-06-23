package B13;

public class ParttimeStudent extends Student{
	
	private Integer learningHourPerDay;

	public ParttimeStudent(String name, Integer learningHourPerDay) {
		super(name);
		this.learningHourPerDay = learningHourPerDay;
	}

	@Override
	public String toString() {
		return "ParttimeStudent [learningHourPerDay=" + learningHourPerDay + ", getName()=" + getName() + "]";
	}


}
