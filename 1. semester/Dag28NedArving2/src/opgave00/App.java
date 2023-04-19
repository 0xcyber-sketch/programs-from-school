package opgave00;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p1 = new Person("Per", 2000);
		Student s1 = new Student("Hans", 1993, "Math");
		Instructor i1 = new Instructor("Lone", 1987, 1400);
		
		System.out.println(p1.toString());
		System.out.println(s1.toString());
		System.out.println(i1.toString());
	}

}
