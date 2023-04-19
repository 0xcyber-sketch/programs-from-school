package exersices;

public class ExersiceE3_13App {

	public static void main(String[] args) {
		ExerciseE3_13 myHybrid = new ExerciseE3_13(20);
		
		//
		myHybrid.addGas(100);
		myHybrid.drive(200);
		double gasLeft = myHybrid.gasLeft();
		System.out.println(gasLeft + " Gallons left");
		

	}

}
