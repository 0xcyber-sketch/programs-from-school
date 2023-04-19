package exersices;

public class ExerciseE3_12 {
	
	// Instant variables
	private String name;
	private double salary;
	
	//Constructors
	public ExerciseE3_12(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	//print salary
	
	public double getSalary() {
		return salary;
	}
	
	// print name
	public String getName() {
		return name;
	}
	
	
	// Raise salary
	public void salaryRaise(double raise) {
		salary = salary * (1+(raise/100));
	}
}
