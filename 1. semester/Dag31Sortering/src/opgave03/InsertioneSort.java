package opgave03;

import java.util.ArrayList;
import java.util.Arrays;

import model.Customer;

public class InsertioneSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul",
				"Torkild" };
//		StringInsertioneSort(s);
		StringInsertioneSortt(s);
		for (String str : s) {
			System.out.println(str);
		}
		Customer c1 = new Customer("Zigurd", "Trols", 21);
		Customer c2 = new Customer("Hansen", "Trols", 21);
		Customer c3 = new Customer("Axel", "Trols", 21);
		Customer c4 = new Customer("Jøren", "Trols", 21);
		ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(c1, c2, c3, c4));

		System.out.println(customers);

		CustomerInsertioneSort(customers);

		System.out.println(customers);

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

	public static void StringInsertioneSort(String[] list) {
		for (int i = 1; i < list.length; i++) {
			String next = list[i];
			int j = i;
			boolean found = false;
			while (!found && j > 0) {
				if (next.compareTo(list[j - 1]) > 0) {
					found = true;
				} else {
					list[j] = list[j - 1];
					j--;
				}
			}
			list[j] = next;
//			swap(list, )

		}

	}

	// TODO
	public static void StringInsertioneSortt(String[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			int j = i + 1;
//			while (list[j - 1].compareTo(list[j]) > 0 && j > 0) {
			while (j > 0 && list[j - 1].compareTo(list[j]) > 0) {
					// Spørg Stotter mandag
					swap(list, j - 1, j);
					j--;
				}

//			}
		}

	}

	public static void CustomerInsertioneSort(ArrayList<Customer> list) {
		for (int i = 1; i < list.size(); i++) {
			Customer next = list.get(i);
			int j = i;
			boolean found = false;
			while (!found && j > 0) {
				if (next.compareTo(list.get(j - 1)) > 0) {
					found = true;
				} else {
					list.set(j, list.get(j - 1));
					j--;
				}
			}
			list.set(j, next);

		}

	}

}
