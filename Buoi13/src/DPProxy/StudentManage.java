package DPProxy;

public class StudentManage {
	
	private StudentResourcesProxy studentResourcesProxy = new StudentResourcesProxy();
	
	public void saveStudent() {
		studentResourcesProxy.save();
	}

}
