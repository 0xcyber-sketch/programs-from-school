package opgave02;

public class Customer implements Comparable<Customer>{

	
	private String name;
	private String lastName;
	private int age;
	
	public Customer(String name, String lastName, int age) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Customer other) {
		int temp = 0;
	
		temp = this.getLastName().compareTo(other.getLastName());
		if (temp == 0) {
			temp = this.getName().compareTo(other.getName());
			if (temp == 0) {
				temp = this.age - other.getAge();
			}
		}
		
		
		return temp;
	}
	
	public String toString() {
		return name + " " + lastName + " " + age;
	}
	
}
