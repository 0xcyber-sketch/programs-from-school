package opgave01;

public class BankAccountApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 1; i < 10; i++) {
			new BankAccount(1000);
		}
		BankAccount b1 = new BankAccount(2000);
		
		System.out.println(b1.getId());
	}

}
