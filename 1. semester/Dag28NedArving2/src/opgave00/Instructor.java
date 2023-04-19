package opgave00;

public class Instructor extends Person{

	private double salary;
	
	public Instructor(String name, int year, double salary) {
		super(name, year);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String toString () {
		return super.getName( ) + " " + super.getYearBorn() + " " +  salary;
	}
		
}
