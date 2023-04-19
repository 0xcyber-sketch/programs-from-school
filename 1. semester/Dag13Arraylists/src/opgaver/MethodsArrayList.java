package opgaver;
import java.util.ArrayList;

public class MethodsArrayList {

	// opgave 1
	
	public int min(ArrayList<Integer> list) {
		int min = Integer.MAX_VALUE;
		for ( int i = 0 ; i < list.size(); i++) {
			if (list.get(i) < min) {
				min = list.get(i);
			}
			
		}
		return min; 
	}
	
	// opg 2
	
	public double average(ArrayList<Integer> list) {
		double sum = 0;
		for ( int number : list) {
			sum += number; 
			}
			
		
		return sum / list.size(); 
	}
	
	//opg 3 
	public int findZero(ArrayList<Integer> list) {
		int amountsOfZero = 0; 
	
		for (int number : list) {
			if (number == 0) {
				amountsOfZero++;
			}
		}
		
		return amountsOfZero; 
	}
	//opg 4 prøve med each senere.
	public void swapEvenWithZero(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				list.set(i, 0);
			}
		}
	}
	//For each attemp TODO
//	public void swapEvenWithZeroF(ArrayList<Integer> list) {
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i) % 2 == 0) {
//				list.set(i, 0);
//			}
//		}
//	}
	// opg 5 
	public ArrayList<Integer> aEvenList(ArrayList<Integer> list){
		ArrayList<Integer> evenList = new ArrayList<>();
		for (int number : list) {
			if (number % 2 == 0) {
				evenList.add(number);
			}
		}
		return evenList;
	}
	
	
	
	
	
	
	
	
	
}
