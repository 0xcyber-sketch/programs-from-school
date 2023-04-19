package opgave02;

import java.util.Arrays;

import model.Customer;

public class Opgave02 {

	public static void main(String[] args) {
		Customer c1 = new Customer("Zigurd", "Trols", 21);
		Customer c2 = new Customer("Hansen", "Trols", 21);
		Customer c3 = new Customer("Axel", "Trols", 21);
		Customer c4 = new Customer("Jøren", "Trols", 21);
		Customer c5 = new Customer("Kaj", "Trols", 21);

		Customer[] customers = new Customer[7];

		customers[0] = c3;
		customers[1] = c2;
		customers[2] = c4;
		customers[3] = c1;

		System.out.println(Arrays.toString(customers));

		insertCustomer(customers, c5);
		System.out.println(Arrays.toString(customers));
	}

	public static void insertCustomer(Customer[] list, Customer c) {
		int i = list.length - 1;
		int index = -1;

		while (i >= 0 && list[i] == null) {
			i--;
		}

		while (i >= 0 && index == -1) {

			if (c.compareTo(list[i]) < 0) {
				list[i + 1] = list[i];
				i--;

			} else {

				index = i;

			}
		}
		list[index + 1] = c;
	}

}
