package model;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer c1 = new Customer("Zigurd", "Trols", 21);
		Customer c2 = new Customer("Hansen", "Trols", 21);
		Customer c3 = new Customer("Axel", "Trols", 21);
		Customer c4 = new Customer("Jøren", "Trols", 21);
		ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(c1, c2, c3, c4));
		
		System.out.println(customers);
		
		
		
		
		
		
	}

}
