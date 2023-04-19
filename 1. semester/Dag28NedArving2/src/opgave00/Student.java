package opgave00;

public class Student extends Person{
	private String mainSubject;
	
	public Student(String name, int year, String subject) {
		super(name, year);
		this.mainSubject = subject;
	}

	public String getMainSubject() {
		return mainSubject;
	}

	public void setMainSubject(String mainSubject) {
		this.mainSubject = mainSubject;
	}
	
	public String toString () {
//		return super.getName( ) + " " + super.getYearBorn() + " " +  mainSubject;
		return super.toString() + " " + mainSubject;
	}

}
