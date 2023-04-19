package model;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("Hans", "Jensen", 22);
		e1.getAge();
		e1.printEmployee();
		e1.printEmployee();
		e1.setName("Kristoffer", "Stodder");
		e1.birthday(); //Opgave 6
		e1.printEmployee();
		
		
		
		
		
		

	}

}
