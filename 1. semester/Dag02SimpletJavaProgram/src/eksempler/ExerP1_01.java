package eksempler;
import javax.swing.JOptionPane;
public class ExerP1_01 {
	public static float usdPrGallaon = 4; //4 dollars
	public static float carMaintancePrMile = 0.05f; // 1 dollar = 100 cents
	
	
	public static float floatToString (String x) {
	 	float result = Float.parseFloat(x);
		return result;
	}
	
	public static void main(String[] args) {
		String distanceFromHomeToWork = JOptionPane.showInputDialog("How long is the distance between home and work");
		String fuelEfficientcy = JOptionPane.showInputDialog("How  fuel efficient is your car?");
		String trainTicket = JOptionPane.showInputDialog("How expensive is a train ticket?");
		
		float distance;
		float efficientcy;
		float trainPrice;

		distance = floatToString(distanceFromHomeToWork);
		efficientcy = floatToString(fuelEfficientcy);
		trainPrice = floatToString(trainTicket);
		
		
		float costprMileM = distance * carMaintancePrMile;
		float gallansPrMile = 1 / efficientcy; // Makes Gallans per 1 mile
		float totalGallans = gallansPrMile * distance;
		float totalPriceCar = (totalGallans * usdPrGallaon) + costprMileM;
		
		if (totalPriceCar < trainPrice ) {
			
			JOptionPane.showMessageDialog(null, "Ride your car!");

		}
		else if (totalPriceCar > trainPrice) {
			JOptionPane.showMessageDialog(null, "Ride the train!");
		}
		
		else {
			JOptionPane.showMessageDialog(null, "It's the same price. Ride your car!");
		}
		
		
		
		
		
		
		
	}

}
