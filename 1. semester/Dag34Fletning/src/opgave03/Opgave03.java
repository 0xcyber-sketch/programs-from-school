package opgave03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import model.Customer;

public class Opgave03 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer c1 = new Customer("Larsen", "Biver", 33);
		Customer c2 = new Customer("Hansen", "Trols", 21);
		Customer c3 = new Customer("Axel", "Trols", 21);
		Customer c4 = new Customer("AE", "Trols", 21);
		Customer c5 = new Customer("Xander", "Trols", 21);
		Customer c6 = new Customer("Hansen", "Kurt", 21);
		Customer c7 = new Customer("Axel", "Tobias", 21);
		Customer c8 = new Customer("Jøren", "Trols", 21);
		Customer c9 = new Customer("Zigurd", "Trols", 21);

		ArrayList<Customer> l1 = new ArrayList<Customer>(Arrays.asList(c1, c2, c3, c4, c5 , c6 , c7 , c8));
		Collections.sort(l1);
		Customer[] l2 = {c4, c6, c9};
		
		System.out.println(goodCustomers(l1, l2));
		
	}
	
	public static ArrayList<Customer> goodCustomers(ArrayList<Customer> l1, Customer[] l2){
		ArrayList<Customer> result = new ArrayList<>();
		int i1 = 0;
		int i2 = 0;
		
		while (i1 < l1.size() && i2 < l2.length) {
			if (l1.get(i1).compareTo(l2[i2]) < 0) {
				result.add(l1.get(i1));
				i1++;
			}
			else if (l1.get(i1).compareTo(l2[i2]) > 0) {
//				result.add(l1.get(i1));
				i2++;
			}
			else {
				i1++;
				i2++;
			}
			
		}
		
		while (i1 < l1.size()) {
			result.add(l1.get(i1));
			i1++;
		}
		
		return result;
	}
	

}
