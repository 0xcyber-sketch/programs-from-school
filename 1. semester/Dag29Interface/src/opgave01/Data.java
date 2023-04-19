package opgave01;

import java.util.ArrayList;

public class Data {

	public static Measurable max(Measurable[] object) {
		double max = Integer.MIN_VALUE;
		Measurable temp = null;
		for (int i = 0; i < object.length; i++) {
			if (object[i].getMeasure() > max) {
				max = object[i].getMeasure();
				temp = object[i];
			}
		}
		return temp;
		
	}
	
	public static double avg(Measurable[] object) {
		double sum = 0;
		for (int i = 0; i < object.length; i++) {
				sum += object[i].getMeasure();
			}
		return sum / object.length;
	}
	public static double avg(ArrayList<Measurable> object) {
		double sum = 0;
		for (int i = 0; i < object.size(); i++) {
				sum += object.get(i).getMeasure();
			}
		
		return sum / object.size();
}
}
