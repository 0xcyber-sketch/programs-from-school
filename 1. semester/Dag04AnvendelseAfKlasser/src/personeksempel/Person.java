package personeksempel;

/**
 * @author Emil
 *
 */
public class Person {
	private String name;
	private String address;
	private double monthlySalary; 
	private int amountOfFirms;
	
	
	/**
	 * 
	 */
	
	public Person(String name, String address,int amountFirms) {
		this.name = name;
		this.address = address;
		this.monthlySalary = 0;
		this.amountOfFirms = amountFirms;
		
	}
	
	
	public Person(String name, String address,  int amountFirms, double salary) {
		this.name = name;
		this.address = address;
		this.monthlySalary = salary;
		this.amountOfFirms = amountFirms;

		
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAddress(String address) {
		this.address = address; 
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setSalary(double salary) {
		this.monthlySalary = salary; 
	}
	
	
	public double getSalary() {
		return this.monthlySalary;
	}
	
	public void printPerson() {
		System.out.println(" *********\n Name: " + name + "\n Address: " + address + "\n Salary: " + monthlySalary  );
		System.out.println(" Yearly salary + vacay money: " + this.yearlySalary());
	}
	
	public double yearlySalary() {
	
		double yearlySalary = (this.monthlySalary * 12) * 1.025;
		return yearlySalary;
	}
	
	public void setAmountOfFirms(int amount) {
		this.amountOfFirms = amount; 
	}
	
	public void newFirm() {
		amountOfFirms++;
	}
	
	
	public int getAmountOfFirms() {
		return this.amountOfFirms;
	}
	
}
