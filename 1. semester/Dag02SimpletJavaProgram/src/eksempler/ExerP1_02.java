package eksempler;

import javax.swing.JOptionPane;




public class ExerP1_02 {
	
	public static float floatToString (String x) {
	 	float result = Float.parseFloat(x);
		return result;
	}
	
	public static float distanceToWork; // Miles
	public static float workDays; // Mon - Fri (z)
	public static float beginningMiles; // x 
	public static float personalUse; 
	public static float endtageMiles; // y
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String distanceFromHomeToWork = JOptionPane.showInputDialog("How long is the distance between home and work?");
		String beginningMilesS = JOptionPane.showInputDialog("What is your beginning miles at?");
		String workDaysS = JOptionPane.showInputDialog("How many days do you want to record?");
		String personalUseS = JOptionPane.showInputDialog("How many miles are for personal use?");

		
		distanceToWork = floatToString(distanceFromHomeToWork);
		beginningMiles = floatToString(beginningMilesS);
		workDays = floatToString(workDaysS);
		personalUse = floatToString(personalUseS);
		
		float totalDistance = (distanceToWork * 2) * workDays;
		endtageMiles = beginningMiles + personalUse + totalDistance;
		//personalUse = endtageMiles - totalDistance;
		float commuteMiles = beginningMiles +  totalDistance;
		
		System.out.println(commuteMiles/endtageMiles);
		
		
		
		
	}

}
