package classtestchapter;

public class BankAccount {
	private double balance;
	public BankAccount() {
		balance = 0;
	}
	public BankAccount(double inializeBallance) {
		balance = inializeBallance;
	}

	public void deposit(double amount) {
		balance = balance + amount;
		
	}
	/**
	 * Withdraws money from the bank account.
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {
		balance = balance - amount;
	}
	/**
	 * Gets the current balance of a bank account
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}
	
	
	

}
