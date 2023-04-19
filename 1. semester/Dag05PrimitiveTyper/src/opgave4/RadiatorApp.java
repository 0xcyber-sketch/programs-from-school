package opgave4;

public class RadiatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Radiator r1 = new Radiator();
		Radiator r2 = new Radiator(22);
		
		System.out.println(r1.getTemperatur());
		System.out.println(r2.getTemperatur()); 
		r1.turnUpTemperatur(15);
		r2.turnDownTemperatur(5);
		
		System.out.println(r1.getTemperatur());
		System.out.println(r2.getTemperatur());
		
		
		
	}

}
