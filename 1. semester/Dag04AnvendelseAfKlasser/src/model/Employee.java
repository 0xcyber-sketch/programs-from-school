package model;

/**
 * Klasse der beskriver en ansat
 *
 * @author MAD
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private String fName;
	private String lName;
	
	private boolean trainee;
	//Opagve b 
	private int age;

	/*
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved
	 * oprettelse er den ansatte en trainee
	 */
	public Employee(String inputFName,String inputLName,int age ) {
		fName = inputFName;
		lName = inputLName;
		trainee = true;
		this.age = age;
		
	}

	/*
	 * Den ansattes navn kan ændres ved kald af setName metoden
	 */
	public void setName(String inputFName, String inputLName) {
		fName = inputFName;
		lName = inputLName;
	}

	/*
	 * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
	 */
	public String getName() {
		return fName + " " + lName;
	}

	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean isTrainee) {
		trainee = isTrainee;
	}

	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {
		return trainee;
	}
	
	// Opagave 3 return age
	public int getAge() {
		return age;
	}
	
	// Opgave 4 set age 
	public void setAge(int inputAge) {
		age = inputAge;
	}

	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("Name " + fName);
		System.out.println("Sirname  " + lName);
		System.out.println("Trainee " + trainee);
		System.out.println("Age " + age);
	}
	
	//opgave 5
	public void birthday() {
		age = age + 1; 
	}
}
