package DPStrategy;

public class Vehicle {
	private Engine engine;
	
	public Vehicle(Engine engine) {
		this.engine = engine;
	}

	public void run() {
		engine.run();	
	}

}
