package opgave01;

// @throws is a precon

/**
 * Models a bank account.  
 */
public class BankAccount {

	private double balance;
	private int id;
	private static int accountNumber = 1000; 

	/**
	 * initializes a bank account.
	 *  
	 */
	public BankAccount(double initialBalance) {
		balance = initialBalance;
		accountNumber++;
		id = accountNumber;
	}

	/**
	 * Amount is added to balance.
	 * Pre: amount > 0.
	 * @param amount is the new amount that is added to balance.
	 * 
	 */
	public void deposit(double amount) {
		balance += amount;
	}
	/**
	 * Mutates balance.
	 * 
	 *  
	 * Pre: amount > 0.
	 * @param amount is the new value subtracted from balance.
	 * 
	 */
	public void withdraw(double amount) {
		balance -= amount;
	}

	/**
	 * Returns the current balance.
	 * 
	 * @return balance.
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Returns the current id.
	 * 
	 * @return id.
	 */
	public int getId() {
		return id;
	}
}
