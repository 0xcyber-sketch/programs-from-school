package opgave02;

public class App {

	public static void main(String[] args) {
	
		Customer[] customers = new Customer[3];
		
		customers[0] = new Customer("Benny", "Karlsen", 30);
		customers[1] = new Customer("Bennie", "Karlsen", 30);
		customers[2] = new Customer("Bennie", "Karlsen", 32);
		
		System.out.println(lastCustomer(customers));
		Customer[] ca =  afterCustomer(customers, customers[1]);
		
		System.out.println();
		for (Customer c : ca) {
			System.out.println(c);
		}
		

	}
	
	public static Customer lastCustomer (Customer[] customers) {
		Customer max = customers[0];
		for (Customer c : customers) {
			if (c.compareTo(max) > 0) {
				max = c;
			}
		}
		return max;
		
	}
	
	public static Customer[] afterCustomer (Customer[] customers, Customer customer) {
		int temp = 0;
		for (Customer c : customers) {
			if (c.compareTo(customer) > 0) {
				temp++;
			}
		}
		
		Customer[] array = new Customer[temp];
		temp = 0;
		for (Customer c : customers) {
			if (c.compareTo(customer) > 0) {
				array[temp] = c;
				temp++;
			}
		}
		return array;
		
	}
	
	

}
