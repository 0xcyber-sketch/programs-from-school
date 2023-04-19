package opgave1;

public class PersonApp {

    public static void main(String[] args) {
        Person p = new Person("Bent", "Janus",  02, 11, 2000);
        p.printPerson();
        System.out.println("Initialer: " + p.getInit());
        System.out.println("Username: " + p.getUserName());

        System.out.println("Age: " + p.age(28, 11, 2020)); // p's age today
         int year = 2100
        		 ;
       System.out.println("Er " + year + " skudår: " + p.leapYear(year));
       
       System.out.println(p.weekDay("Monday", 2001));
       System.out.println("Expected Tuesday");

    }
}
