package DPStrategy;

public class MainStrategy {
	public static void main(String[] args) {
		MotoEngine motoEngine = new MotoEngine();
		
		Vehicle vehicle = new Vehicle(motoEngine);	
		vehicle.run();
		
		Engine plainEngine = new PlaintEngine();
		Vehicle plain = new Vehicle(plainEngine);
		plain.run();
	}

	
	
	
	

}
