package opgave01;

import java.util.ArrayList;
import java.util.Arrays;

import model.Customer;
import sort.SelectionSort;
public class Opgave01 {

	public Opgave01() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer c1 = new Customer("Zigurd", "Trols", 21);
		Customer c2 = new Customer("Hansen", "Trols", 21);
		Customer c3 = new Customer("Axel", "Trols", 21);
		Customer c4 = new Customer("Jøren", "Trols", 21);
		Customer c5 = new Customer("Kaj", "Trols", 21);
		ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(c1, c2, c3, c4));
		
//		System.out.println(customers);
		
		
		SelectionSort.customerSelectionSort(customers);
		
		System.out.println(customers);
		
		insertCustomer(customers, c5);
		System.out.println(customers);

	}
	public static void insertCustomer(ArrayList<Customer> list, Customer c) {
		int i = 0; 
		int index = -1;
		
		while (i < list.size() && index == -1) {
			if (c.compareTo(list.get(i)) < 0) {
				index = i;
				list.add(index, c);
				
			}
			else {
				i++;
			}
			
		}
		
	}

}
