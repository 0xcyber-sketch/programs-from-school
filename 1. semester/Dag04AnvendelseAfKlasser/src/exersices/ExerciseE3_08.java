package exersices;

public class ExerciseE3_08 {
	
	//Initialized variables
	private double amount;
	private String name;

	
	//Constructor class
	public ExerciseE3_08(String name, double amount) {
		this.amount = amount;
		this.name = name;
		
	}

	//Withdraw
	public void withdrawMoney(double amount) {
		this.amount = this.amount - amount;
	}
	
	//Deposits
	public void depositMoney(double amount) {
		this.amount = this.amount + amount;
	}
	
	// Print bank information
	public void printBankAccount() {
		System.out.println("Name: " + name);
		System.out.println("Total amount: " + amount);
	}
	
	// Add interest
	public void addInterest(double interest) {
		this.amount = amount * (1+(interest/100)) ;
	}
	

}
