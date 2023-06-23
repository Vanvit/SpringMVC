package DPProxy;

public class ClassResources {
	
	private StudentResourcesProxy studentResourcesProxy = new StudentResourcesProxy();
	
	public void saveStudent() {
		studentResourcesProxy.save();
	}

}
