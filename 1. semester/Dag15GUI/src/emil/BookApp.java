package emil;

// Opgave 2 App
import java.util.Scanner;
public class BookApp {
	public static void main(String[] args) {
	Book b1 = new Book("A Song of Ice and Fire", false, 20.95);
	Book b2 = new Book("Big Java", true, 40.95);
	
	System.out.println(b1.getTitle());
	System.out.println(b1.getPrice());
	
	System.out.println();
	
	System.out.println(b2.getTitle());
	System.out.println(b2.getPrice());
	
	b2.printBook();
	
	System.out.println();
	
	b1.printBook();
	
	System.out.println();
	Scanner scan = new Scanner (System.in);
	
	String title = "";
	double price = 0;
	boolean paperback = false;
	
	
	System.out.println("What is the titl?");
	title = scan.nextLine();
	
	System.out.println("What is the price?");
	
	price = scan.nextDouble();
	
	System.out.println("Is the book a paper back?");
	
	String temp = scan.nextLine();
	if (temp.equalsIgnoreCase("yes")) {
		paperback = true;
	}
	
	Book b3 = new Book(title, paperback, price);
	
	b3.printBook();
	
	scan.close();
	
	
	
	
	
	
	}
}
