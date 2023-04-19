package opgave1;

/**
 * Write a description of class Person here.
 *
 * @author (Margrethe Dybdahl)
 * @version (16/09/2020)
 */
public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	private int dayOfBirth; // 1..31
	private int monthOfBirth; // 1..12
	private int yearOfBirth; // 1900..2010

	/**
	 * Constructor for objects of class Person
	 */

	public Person(String firstName, String middleName, String lastName,
			int dayOfBirth, int monthOfBirth, int yearOfBirth) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
		this.monthOfBirth = monthOfBirth;
		this.yearOfBirth = yearOfBirth;

	}
	public Person(String firstName, String lastName,
			int dayOfBirth, int monthOfBirth, int yearOfBirth) {
		this.firstName = firstName;
		this.middleName = "";
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
		this.monthOfBirth = monthOfBirth;
		this.yearOfBirth = yearOfBirth;
	}



	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void printPerson() {
		System.out.println(firstName + " " + middleName + " " + lastName + " "
				+ dayOfBirth + "." + monthOfBirth + "." + yearOfBirth);

	}

	public String getInit() {
		String init;
		if (!middleName.equals("")) {

			init = "" + firstName.charAt(0) + middleName.charAt(0)
			+ lastName.charAt(0);
		}
		else {
			init = "" + firstName.substring(0, 2) + lastName.substring(0, 2);
		}
		return init;
	}

	public String getUserName() {
		String tekst1 = firstName.substring(0, 2).toUpperCase();
		String tekst2 = middleName.length() + "";
		String tekst3 = lastName.substring(lastName.length() - 2);
		
		if (middleName.equals("")) {
			
			
			tekst2 = (firstName.length() - lastName.length()) + "";
	
		}

		return tekst1 + tekst2 + tekst3;

	}

	public int age(int dayToDay, int monthToDay, int yearToDay) {
		int age; // TODO make the code work

		if (monthOfBirth < monthToDay) {
			age = yearToDay - this.yearOfBirth;
		}

		else if  ( monthOfBirth ==  monthToDay ) {

			if (dayToDay > dayOfBirth) {
				age = yearToDay - this.yearOfBirth;
			}

			else if (dayToDay == dayOfBirth) {
				age = yearToDay - this.yearOfBirth;
			}


			else {
				age = yearToDay - this.yearOfBirth - 1;
			}
		}
		else 
		{
			age = yearToDay - this.yearOfBirth- 1;
		}


		return age;
	}

	/**
	 * Returns whether year is a leapyear
	 *
	 * @param year
	 * @return
	 */
	public boolean leapYear(int year) {
		boolean leapYear = false; // TODO make the code work
		if (year % 4 == 0) {
			leapYear = true;
			if (year % 100 == 0) {
				leapYear = false;
				if (year % 400 == 0) {
					leapYear = true;
				}
			}
		}



		return leapYear;
	}

	public String weekDay(String day, int year) {
		int yearDifference = this.yearOfBirth;
		int month = this.monthOfBirth;
		String weekday = "";
		int thisDay = 0;

		if (day.equals("Monday")) {
			thisDay = 1;
		}
		else if (day.equals("Tuesday")) {
			thisDay = 2;
		}
		else if (day.equals("Wednesday")) {
			thisDay = 3;
		}
		else if (day.equals("Thursday")) {
			thisDay = 4;
		}
		else if (day.equals("Friday")) {
			thisDay = 5;
		}
		else if (day.equals("Saturday")) {
			thisDay = 6;
		}
		else if (day.equals("Sunday")) {
			thisDay = 7;
		}
		System.out.println(thisDay);

		while (yearDifference != year) {

			if (thisDay < 8 ) {
				thisDay = 1;
			}

			if (this.leapYear(yearDifference)) {
				thisDay += 2;

			}
			else {
				thisDay++;
			}


			yearDifference++;

		}

		if (this.leapYear(this.yearOfBirth)) {
			if (month > 2) {
				thisDay--;
			}

			if (this.leapYear(year)) {
				if (month < 3) {
					thisDay++;
				}
			}



			if (thisDay == 1) {
				weekday = "Monday";
			}
			else if (thisDay == 2) {
				weekday = "Tuesday";
			}
			else if (thisDay == 3) {
				weekday = "Wednesday";
			}
			else if (thisDay == 4) {
				weekday = "Thursday";
			}
			else if (thisDay == 5) {
				weekday = "Friday";
			}
			else if (thisDay == 6) {
				weekday = "Saturday";
			}
			else if (thisDay == 7) {
				weekday = "Sunday";
			}

	
		}
		return weekday;
	}
}
