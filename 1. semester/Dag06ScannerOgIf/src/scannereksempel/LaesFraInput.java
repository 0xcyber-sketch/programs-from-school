package scannereksempel;

import java.util.Scanner;

public class LaesFraInput {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hvad er dit fornavn ? ");
		String fornavn = scan.nextLine();
		
		System.out.println("Hvad er dit efternavn ? ");
		String efternavn = scan.nextLine();
		
		System.out.println("Hvor gammel er du ? ");
		int alder = scan.nextInt();

		System.out.println(fornavn + " " + efternavn + " " + alder);
		scan.close();

	}

}
