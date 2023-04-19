package opgave4;
import java.util.Scanner;

public class CardsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		Cards c1 = new Cards(in); 
		System.out.println(c1.getDescription());
		scan.close();
	}

}
