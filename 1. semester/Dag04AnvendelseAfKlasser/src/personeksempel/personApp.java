package personeksempel;

public class personApp {

	public static void main(String[] args) {
		Person p1 = new Person("Stodder", "Trekantvej", 8, 1000);
		p1.printPerson();
		p1.yearlySalary();

		System.out.println(p1.getAmountOfFirms()); 
		p1.newFirm();
		System.out.println(p1.getAmountOfFirms()); 

	} 

}
