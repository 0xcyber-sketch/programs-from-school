package opgave2Teater;

import java.util.Scanner;

public class TheaterFloorApp {

	public static void main(String[] args) {
		TheaterFloor theater = new TheaterFloor();
		// TODO
		theater.printTheaterFloor(theater.seats);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Do you wish to find a seat by price or the seat and row?");
		String input = scan.nextLine();
		
		if (input.equalsIgnoreCase("price")) {
			System.out.println("Which price?");
			int price = scan.nextInt();
			
			theater.buySeat(price); 
			
			
			
		} else if (input.equalsIgnoreCase("seat")) {
			System.out.println("Which row ");
			int row = scan.nextInt();
			System.out.println("Which seat? ");
			int seat = scan.nextInt();
			
			if (theater.buySeat(row - 1, seat - 1) != 0  ) {
				System.out.println(" You seat is reserved");
			}
			else {
				System.out.println("The seat is occupied");
			}
			
		}
		else {
			System.out.println("Not an option, purchase canceled");
		}
		
		
		
//		theater.buySeat(50);
		theater.printTheaterFloor(theater.seats);
		
//		System.out.println(theater.seats.length);
//		System.out.println(theater.buySeat(0,2));
//		System.out.println(theater.buySeat(0,2));
		
	}
}
