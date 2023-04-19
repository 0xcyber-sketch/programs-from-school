package sort;

import java.util.ArrayList;
import java.util.Arrays;

import model.Customer;

public class SelectionSort {
	
	public static void main(String[] args) {
		String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul", "Torkild"};
		stringSelectionSort(s);
		for(String str : s) {
			System.out.println(str);
		}
		
		Customer c1 = new Customer("Zigurd", "Trols", 21);
		Customer c2 = new Customer("Hansen", "Trols", 21);
		Customer c3 = new Customer("Axel", "Trols", 21);
		Customer c4 = new Customer("Jøren", "Trols", 21);
		ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(c1, c2, c3, c4));
		
		System.out.println(customers);
		
		customerSelectionSort(customers);
		
		System.out.println(customers);
		
		
	}

	
	
	public static void stringSelectionSort(String[] list) {
		for (int i = 0; i < list.length; i++) {
			int minPos = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[j].compareTo(list[minPos]) < 0) {
					minPos = j;
				}
			}
			swap(list, i, minPos);
		}
	}
	private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
	private static void swap(ArrayList<Customer> customers, int i, int j) {
        Customer temp = customers.get(i);
        customers.set(i, customers.get(j));
        customers.set(j, temp);
    }
	
	public static  void customerSelectionSort(ArrayList<Customer> customers) {
		for (int i = 0; i < customers.size(); i++) {
			int minPos = i;
			for (int j = i + 1; j < customers.size(); j++) {
				if (customers.get(j).compareTo(customers.get(minPos)) < 0) {
					minPos = j;
				}
			}
			swap(customers, i, minPos);
		}
	}
}
