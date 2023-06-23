package DPProxy;

public class StudentResourcesProxy {
	
	private StudentResources studentResources = new StudentResources();
	
	public void save() {
		studentResources.save();
	}

}
