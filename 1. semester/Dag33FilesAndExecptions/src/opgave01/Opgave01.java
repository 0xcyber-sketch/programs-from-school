package opgave01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Opgave01 {

	public Opgave01() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prim = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Hvilket nr. primtal skal vises?: ");
			int n = scan.nextInt();
			System.out.println("Primtal nr. " + n + " er " + prim[n - 1] + "\n");
		}
		catch (InputMismatchException e) {
			System.out.println("Du kan kun skrive tal");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Du kan vælge et tal mellem 1 - 10");
		}
		
	}
}
