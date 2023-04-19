package classtestchapter;
//import BankAccount

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount millo = new BankAccount();
		millo.deposit(300);
		System.out.println(millo.getBalance());
		millo.withdraw(200);
		System.out.println("Expected 1600");
		System.out.println(millo.getBalance());
		
	}

}
