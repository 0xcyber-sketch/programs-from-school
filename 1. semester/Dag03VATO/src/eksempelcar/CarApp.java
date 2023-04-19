package eksempelcar;

public class CarApp {

	public static void main(String[] args) {
		Car myCar = new Car("VW UP", "White");
		System.out.println(myCar.getBrand());
		myCar.setRegistrationNumber("AB 11 123");
		System.out.println(myCar.getRegistrationNumber());
		
		Car coolCar = new Car("Tesla", "Blue");
		coolCar.setRegistrationNumber("Yeet");
		coolCar.setKm(2);
		System.out.println("Cars color: " + coolCar.getColor() + "\n" 
				+ "Car brand: " + coolCar.getBrand() + "\n"
				+ "Car reg. number: " + coolCar.getRegistrationNumber() + "\n" +
				"Car km count: " + coolCar.getKm());

	}

}
