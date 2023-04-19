package random;
import java.lang.Math;

public class Random {
	
	
	
	public static int randomRange(int minValue, int maxVale) {
		/*
		 * Math.random chooses a number (x) that is x>= 0 and x < 1. This means the max value is 
		 * 0.9999999... 
		 * The range makes the off set. Scales the values up to the proper values. The + 1 
		 * Is to make sure the last digigt is included.(See Example beneath)
		 * The plus min is to make sure that you get either the max value and the minimum value.
		 * Example:
		 * min = 2, max = 10
		 * Range = 10 - 2 + 1 = 9
		 * Math.ran = 0.9999...
		 * 8.9... = 8 
		 * 8 + 2 = 10
		 * 
		 * 
		 * min = 2, max = 16
		 * Range = 10 - 2 + 1 = 9
		 * Math.ran = 0.000001...
		 * 0.000001... = 0
		 * 0 + 2 = 2
		 * 
		 * 
		 */
		int range = maxVale - minValue +1;
		int rand = (int)(Math.random() * range) + minValue;
		return rand;
		
	}
	
	
	
	
}
