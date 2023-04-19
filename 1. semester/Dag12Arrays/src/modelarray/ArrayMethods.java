package modelarray;

import java.util.Arrays;

public class ArrayMethods {
	public void printArray(int[] tabel) {
		System.out.print("{");
		for (int i = 0; i < tabel.length; i++) {
			if (i == 0) {
				System.out.print(tabel[i]);
			}
			else {
				System.out.print(", " + tabel[i]);
			}
		}
		System.out.println("}  ");
	}

	/**
	 *
	 * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
	 */
	public int[] fyldArrayA() {
		int[] result = new int[10];
		return result;
	}

	/**
	 *
	 * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
	 */
	public int[] fyldArrayB() {
		int[] result = {2,44,-23,99,8,-5,7,10,20,30};

		return result;
	}

	/**
	 *
	 * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
	 */
	public int[] fyldArrayC() {
		int[] result = new int[10];
		//TODO

		for (int i = 0; i < result.length; i++) {
			result[i] += i;
		}
		return result;
	}

	/**
	 *
	 * @return et array med indhold [2,4,6,8,10,12,14,16,18,20]
	 */
	public int[] fyldArrayD() {
		int[] result = new int[10];
		//TODO
		int j = 2;
		for (int i= 0; i < result.length; i++) {
			result[i] += j;
			j += 2;
		}

		return result;
	}

	/**
	 *
	 * @return et array med indhold [1,4,9,16,25,36,49,64,81,100]
	 */
	public int[] fyldArrayE() {
		int[] result = new int[10];
		for (int i= 0; i < result.length; i++) {

			result[i]  = (i+1) * (i+1);
		}
		//TODO
		return result;
	}

	/**
	 *
	 * @return et array med indhold [0,1,0,1,0,1,0,1,0,1]
	 */
	public int[] fyldArrayF() {
		int[] result = new int[10];
		for (int i= 0; i < result.length; i++) {

			if ( i % 2 == 0) {
				result[i] = 0;
			}
			else {
				result[i] = 1;}
		}
		return result;
	}

	/**
	 *
	 * @return et array med indhold [0,1,2,3,4,0,1,2,3,4]
	 */
	public int[] fyldArrayG() {
		int[] result = new int[10];
		int j = 0;
		for (int i= 0; i < result.length; i++) {

			if ( i % 5 == 0) {
				result[i] = 0;
				j = 0;
			}
			else {
				result[i] += j;
				
			}
			j++;
		}

		return result;
	}

	public int findMax(int[] tabel) {
		int max = -1;
		for (int i = 0; i < tabel.length; i++) {
			if (tabel[i] > max) {
				max = tabel[i];
			}
		}
		return max;
	}
	
	public int sum(int[] tabel) {
		int sum = 0;
		for (int i = 0; i < tabel.length; i++) {
			sum += tabel[i];
		}
		
		return sum;
	}
	public double sumDouble(double[] tabel) {
		double sum = 0;
		for (int i = 0; i < tabel.length; i++) {
			sum += tabel[i];
		}
			
		return sum;
	}
	
	//Opgave 3
	public int[] makeSum(int[] a, int [] b) {
		// Det antages at array a og b er lige lange
		int[] t = new int[a.length];
		for ( int i = 0; i < t.length; i++) {
			t[i] = a[i] + b[i];
			
		}
		
		return t;
	}
	//Opgave 7
	public int[] makeSumDiff(int[] a, int [] b) {
		// 
		int[] t; 
		if (a.length > b.length) {
			t = new int[a.length];
		}
		else   {
			t = new int[b.length];
		}
		
		
		for (int i = 0; i < a.length; i++) {
			t[i] = a[i];
			
		}
		for (int i = 0; i < b.length; i++) {
			t[i] += b[i]; 
		}
		
		return t;
	}
	
	public boolean hasUneven(int[] t) {
		boolean uneven = false;
		for (int i = 0; i < t.length; i++) {
			if (t[i] % 2 != 0) {
				uneven = true;
			}
			
		}
		return uneven;
	}
	
	
}
