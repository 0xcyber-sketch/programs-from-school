package application.model;

public class Customer {

	private String name;
	private String address;
	
	public Customer (String name, String adress) {
		this.name = name;
		this.address = adress;
		
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		return name + " (" +address + ")" ;
	}
	}
