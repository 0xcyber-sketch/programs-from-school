package opgaver;
import java.util.Arrays;
import java.util.ArrayList;

public class ArrayMethods {
	//opgave 4
	public int[] swapFirstAndLast(int[] a) {
		
		int temp = a[0];
		a[0] = a[a.length-1];
		a[a.length-1] = temp;
		
			
		return a;
	}
	
	
public int[] moveRight(int[] a) {
		
		int[] result = new int[a.length];
		result[0] = a[result.length-1];
		for (int i = 1; i < a.length; i++) {
			result[i] = a[i - 1];
			
		}
			
		return result;
	}

public int[] overRideEven(int[] a) {
	int temp;
	for (int i = 0; i < a.length; i++) {
		temp = a[i];
		
		if (temp % 2 == 0) {
			a[i] = 0;
		}
		
	}
		
	return a;
}

public int findSecondHighest(int[] a) {
	int max = Integer.MIN_VALUE;
	int temp = Integer.MIN_VALUE;
	for (int i = 0; i < a.length; i++) {
		
		if (a[i] > max) {
			max = a[i];
		}
		
		
	}
	for (int i = 0; i < a.length; i++) {
		
		if (a[i] > temp && a[i] < max) {
			temp = a[i];
		}}
	
	
		
	return temp;
} 
	//Whoops overarbejde
	public int[] sortIncreasing(int[] a) {
		int temp = 0;  
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length ; j++) {
				if (a[i] > a[j]) {
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
					
				}
			}
		}
		return a;
	}
	
	public boolean returnTrueWhenSortingInc (int[] a) {
		boolean temp = false;
		for (int i = 1; i < a.length-1; i++) {
			if (a[i] < a[i + 1] && a[i] > a[i - 1]) {
				temp = true;
			}
		}
		
		return temp;
	}
	
	public boolean returnTrueWhenThereisMoreThanOne (int[] a) {
		boolean dublet = false;
		int temp = 0;
		int i = 0;
		System.out.println(a.length);
		while (i < a.length-1 && dublet == false) {
			temp = a[i];
			for (int j = i + 1; j < a.length; j++) {
					if (a[j] == temp) {
						dublet = true;
					}
			}
			i++;
		}
		
		return dublet;
	}
	
	//Lav opgaverne med arraylist
	
	public ArrayList<Integer> swapFirstAndLastList(ArrayList<Integer> a) {
		int temp = a.get(0);
		a.set(0, a.get(a.size()-1));
		a.set(a.size()-1, temp);
		return a;
	}
	public ArrayList<Integer> moveRightList(ArrayList<Integer> a) {
		
		
		int t ;
		
		
		for (int i = a.size()-1; i > 0 ; i--) {
			t = a.get(i-1);
			a.set(i-1, a.get(i));
			a.set(i, t);
					
		}
		
		return a;
	}
public ArrayList<Integer> overRideEvenList(ArrayList<Integer> a) {
		
		
		for (Integer number : a) {
			if (number % 2 == 0) {
				a.set(a.indexOf(number), 0);
			}
		}
		
		return a;
	}
	
public int findSecondHighestList(ArrayList<Integer> a) {
	
	int max = Integer.MIN_VALUE;
	int sec = Integer.MIN_VALUE;
	for (Integer number : a) {
		if (number > max) {
			max = number;
		}
		
	}
	
	for (Integer number : a) {
		if (number < max && number > sec) {
			sec = number;
		}
		
	}
	
	return sec;
}

public boolean returnTrueWhenSortingIncList(ArrayList<Integer> a) {
	
	boolean increasing = false;
	for(int i = 1; i < a.size()-1; i++) {
		if (a.get(i-1) < a.get(i) &&  a.get(i+1) > a.get(i)) {
			increasing = true;
			
		}
		
	}
	
	return increasing;
}
public boolean returnTrueWhenThereisMoreThanOneList (ArrayList<Integer> a) {
	boolean dublet = false;
	int temp = 0;
	int i = 0;
	while (i < a.size() && dublet == false) {
		temp = a.get(i);
		for (int j = i + 1; j < a.size(); j++) {
				if (a.get(j) == temp) {
					dublet = true;
				}
		}
		i++;
	}
	
	return dublet;
}
	
	
}
