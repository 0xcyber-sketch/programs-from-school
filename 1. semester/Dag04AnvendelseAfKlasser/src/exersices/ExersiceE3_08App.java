package exersices;

public class ExersiceE3_08App {

	public static void main(String[] args) {
		ExerciseE3_08 bankAccount = new ExerciseE3_08("Emil", 1000);
		bankAccount.printBankAccount();
		bankAccount.addInterest(10);
		bankAccount.printBankAccount();

	}

}
