package opgave02;

import java.util.Arrays;

public class Opgave02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] l1 = {2,4,6,8,10,12,14};
		int[] l2 = {1,2,4,5,6,9,12,17};
		
		System.out.println(Arrays.toString(fællesTal(l1, l2)));
		
		
	}
	public static int[] fællesTal(int[] l1, int[] l2) {
		int[] result = new int[l2.length];
		int iResult = 0;
		int i1 = 0;
		int i2 = 0; 
		
		while (i1 < l1.length && i2 < l2.length) {
			if (l1[i1] < l2[i2]) {
				i1++;
			}
			else if (l1[i1] > l2[i2]) {
				i2++;
			}
			else {
				result[iResult] = l1[i1];
				iResult++;
				i1++;
				i2++;
			}
		}
		
//		while (i1 < l1.length) {
//			result[iResult] = l1[i1];
//			iResult++;
//			i1++;
//		}
		
		return result;
	}
	

}
