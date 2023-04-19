package exersices;

public class ExerciseE3_13 {
	private double milesPrGallon; //Miles per gallon efficiency
	private double gas;
	private double distance;

	public ExerciseE3_13(double milesPrGallon) {
		
		this.milesPrGallon = milesPrGallon;
		this.gas = 0;
		this.distance = 0;
	}
	
	public void addGas(double gas) {
		this.gas = gas;
		
	}
	
	//Drive x amount of miles
	public void drive(double distance) {
		this.distance = distance;
		
	}
	
	public double gasLeft() {
		//Finds max distance on gas amount
		double managableDistance = this.gas * this.milesPrGallon;
		//Check if max is bigger than the distance
		if (managableDistance > this.distance) {
			//Return gas left 
			return (managableDistance - this.distance)/this.milesPrGallon;
			
			
		}
		
		else {
			return 0;
		}
		
		
		
	}
	
	public double getGas() {
		return gas;
	}
	
	
}
