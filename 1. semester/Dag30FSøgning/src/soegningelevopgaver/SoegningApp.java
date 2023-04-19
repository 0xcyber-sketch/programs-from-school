package soegningelevopgaver;

import java.util.ArrayList;

public class SoegningApp {

	 
	
	public static void main(String[] args) {
		Soegning s = new Soegning();
		
		// Kode til afprøvning af opgave 1
		int[] talArray = {2,4,8,2};
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));

		// Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7
		
		 int[] talArray2 = {7, 56, 34, 3, 7, 14, 13, 4};
		 System.out.println(s.linearSearchTenToFifteen(talArray2, 10, 15));
		 
		 int[] talArray3 = {7, 9, 13, 7, 9, 13};
		 System.out.println(s.linearSearchTwoInARow(talArray3));
		 talArray3[3] = 13;
		 System.out.println(s.linearSearchTwoInARow(talArray3));
		 
		 int temp = 31;
		 System.out.println(s.linearSearchTaskFive(temp));
		 System.out.println(s.binarySearchTaskFive(temp));
		 
		 ArrayList<Integer> list = new ArrayList<>();
		 list.add(6);
		 list.add(4);
		 list.add(8);
		 list.add(13);
		 list.add(2);
		 
		 System.out.println(list);
		 System.out.println(s.find(list, 2));
		 System.out.println(list);

		 

	}

}
