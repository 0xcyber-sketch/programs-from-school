package opgave01;

import java.util.Scanner;

public class EexersiceE5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Write an integer: ");
		int integer1 = scan.nextInt();
		
		if (integer1 > 0) {
			System.out.println("Positive");
		}
		else if (integer1 == 0 ) {
			System.out.println("Zero");
		}
		else {
			System.out.println("Negative");
		}
		
		scan.close();
	}

}
