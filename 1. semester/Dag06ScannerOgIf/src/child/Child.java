package child;


public class Child {
	private int age;
	private boolean boy; // true if the child is a boy

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	
	
	/**
	 * Opgave 2
	 * @return
	 */
	public String institution() {
		// TODO: implement!
		
		String ins;
		
		if (age == 0) {
			ins = "Home";
		}
		else if (age > 0 && age < 3)
		{
			ins = "Nursey";
		}
		
		else if (age > 3 && age < 6)
		{
			ins = "Kindergarten";
		}
		
		else if (age > 6 && age < 17)
		{
			ins = "School";
		
		}
		
		else {
			ins = "Out of school";
		}
		return ins;
	}
	
	/**
	 * Opgave 4
	 * @return
	 */
	public String gender() {
		
		if (boy == true) {
			return "boy";
		}
		else {
			return "girl";
		}
		
	}
	
	public String team() {
		String team;
		if (!boy) {
			if (age >= 8) {
				team = "Spingy girls";
				
			}
			else {
				
				team = "Tumbeling girls";
			}
		}
		else {
			if (age >= 8) {
				team = "Cool boys";
			}
			else {
				team = "Young cubs";
				}
		}
		
		return team;
	}

}
