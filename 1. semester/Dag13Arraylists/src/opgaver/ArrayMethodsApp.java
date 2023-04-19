package opgaver;

import java.util.ArrayList;
import java.util.Arrays;
public class ArrayMethodsApp {

	public static void main(String[] args) {
		
		int[] tabel = {8,8,6,9,4,5};
		
		ArrayMethods a1 = new ArrayMethods();
		
		System.out.println("Forventet [5, 8, 6, 9, 4, 8]");
		System.out.println(Arrays.toString(a1.swapFirstAndLast(tabel)));
		
		System.out.println("Forventet [8, 5, 8, 6, 9, 4]");
		System.out.println(Arrays.toString(a1.moveRight(tabel)));
		
		//System.out.println(Arrays.toString(tabel));
		
		int[] tabel2 = {12,8,7,9,4,5};
		System.out.println("Forventet [0,0,7,9,0,5]");
		System.out.println(Arrays.toString(a1.overRideEven(tabel2)));
		
		int[] tabel3 = {12,8,7,9,4,5};
		System.out.println("Forventet 9");
		System.out.println((a1.findSecondHighest(tabel3)));
		
		int[] tabel4 = {12,8,51,7,31,9,4,5};
		System.out.println("Forventet [4,5,7,8,9,12,31,51]");
		System.out.println(Arrays.toString(a1.sortIncreasing(tabel4)));
		
		System.out.println("[4,5,7,8,9,12,31,51]");
		System.out.println("Forventet true");
		System.out.println(a1.returnTrueWhenSortingInc(tabel4));
		
		int[] tabel5 = {12,8,51,7,31,9,4,5};
		System.out.println("Forventet false");
		System.out.println(a1.returnTrueWhenSortingInc(tabel5));	
		
		
		
		System.out.println("Forventet false");
		System.out.println(a1.returnTrueWhenThereisMoreThanOne(tabel5));
		int[] tabel6 = {12,8,51,8,31,9,4,5};
		
		System.out.println("Forventet true");
		System.out.println(a1.returnTrueWhenThereisMoreThanOne(tabel6));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(3);
		list.add(92);
		list.add(2);
		list.add(3);
		list.add(92);
		list.add(8);
		list.add(1);
		list.add(6);
		list.add(0);
		list.add(0);
		list.add(32);
		System.out.println("Forventet [32,3,92,2,3,92,8,1,6,0,0,5]");
		System.out.println(a1.swapFirstAndLastList(list));
		
		System.out.println();
		System.out.println(list);
		
		System.out.println("Forventet [5,32,3,92,2,3,92,8,1,6,0,0]");
		System.out.println(a1.moveRightList(list));
		// TODO Auto-generated method stub

		System.out.println("Forventet [5,0,3,0,0,3,0,0,1,0,0,0]");
		System.out.println(a1.overRideEvenList(list));
		
		System.out.println("Forventet 3");
		System.out.println(a1.findSecondHighestList(list));
		
		list.clear();
		
		list.add(6);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		
		System.out.println("Forventet false");
		System.out.println(a1.returnTrueWhenSortingIncList(list));
		list.set(0, 3);
		System.out.println("Forventet true");
		System.out.println(a1.returnTrueWhenSortingIncList(list));
		
		System.out.println("Forventet false");
		System.out.println(a1.returnTrueWhenThereisMoreThanOneList(list));
		
		list.add(5);
		System.out.println("Forventet true");
		System.out.println(a1.returnTrueWhenThereisMoreThanOneList(list));
	}	
	

}
