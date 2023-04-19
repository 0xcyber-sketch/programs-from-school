package opgave01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import model.Customer;

public class Opgave01 {

	public static void main(String[] args) {
		Customer c1 = new Customer("Larsen", "Biver", 33);
		Customer c2 = new Customer("Hansen", "Trols", 21);
		Customer c3 = new Customer("Axel", "Trols", 21);
		Customer c4 = new Customer("AE", "Trols", 21);
		Customer c5 = new Customer("Xander", "Trols", 21);
		Customer c6 = new Customer("Hansen", "Kurt", 21);
		Customer c7 = new Customer("Axel", "Tobias", 21);
		Customer c8 = new Customer("Jøren", "Trols", 21);
		Customer c9 = new Customer("Zigurd", "Trols", 21);

		ArrayList<Customer> l1 = new ArrayList<Customer>(Arrays.asList(c1, c2, c3, c4, c9));
		ArrayList<Customer> l2 = new ArrayList<Customer>(Arrays.asList(c5, c6, c7, c8));

		Collections.sort(l1);
		Collections.sort(l2);
		
		System.out.println(fletAlleKunder(l1, l2));
		System.out.println();
		System.out.println(fletAlleKunder(l1, l2));
		
		System.out.println(Integer.MAX_VALUE);

	}

	public static ArrayList<Customer> fletAlleKunder(ArrayList<Customer> l1, ArrayList<Customer> l2) {
		ArrayList<Customer> result = new ArrayList<>();
		int i1 = 0;
		int i2 = 0;

		while (i1 < l1.size() && i2 < l2.size()) {
			if (l1.get(i1).compareTo(l2.get(i2)) <= 0) {
				result.add(l1.get(i1));
				i1++;
			} else {
				result.add(l2.get(i2));
				i2++;
			}

		}
		while (i1 < l1.size()) {
			result.add(l1.get(i1));
			i1++;
		}
		while (i2 < l2.size()) {
			result.add(l2.get(i2));
			i2++;
		}

		return result;

	}

}
