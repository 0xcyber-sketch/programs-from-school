package opgave04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import model.Customer;

public class TestSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> list = new ArrayList<String>();
		list.add("Jan");
		list.add("Bent");
		list.add("Thomas");
		list.add("Karsten");
		list.add("Dan");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		Customer c1 = new Customer("Zigurd", "Trols", 21);
		Customer c2 = new Customer("Hansen", "Trols", 21);
		Customer c3 = new Customer("Axel", "Trols", 21);
		Customer c4 = new Customer("Jøren", "Trols", 21);
		ArrayList<Customer> list2 = new ArrayList<Customer>(Arrays.asList(c1, c2, c3, c4));
		
		System.out.println(list2);
		Collections.sort(list2);
		System.out.println(list2);
		
		
	
	}

}
