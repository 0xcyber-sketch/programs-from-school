package opgave00;

public class Person {

	private String name; 
	private int yearBorn;
	
	public Person(String name, int year) {
		this.name = name;
		yearBorn = year;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setYearBorn(int year) {
		yearBorn = year;
	}
	
	public int getYearBorn() {
		return yearBorn;
	}
	
	@Override
	public String toString() {
		return name + " " + yearBorn;
	}
}
