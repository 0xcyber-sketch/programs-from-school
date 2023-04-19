package opgave2Teater;

public class TheaterFloor {
	int[][] seats = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
			{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
			{ 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 }, { 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
			{ 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };

	/**
	 * Hvis plads seat på række row er ledig reserveres pladsen og prisen på pladsen
	 * returneres. Der returneres 0 hvis pladsen er optaget.
	 *
	 * @param row
	 * @param seat
	 * @return
	 */

	public int buySeat(int row, int seat) {
		int price = 0;
		if (seats[row][seat] != 0) {
			price = seats[row][seat];
			seats[row][seat] = 0;

		}

		return price;
	}

	/**
	 * Hvis der er en plads ledig med den pågældende pris, reserveres pladsen og
	 * prisen returneres. Der returneres 0, hvis der ikke er nogen pladser ledige
	 * til den pågældende pris.
	 *
	 * @param row
	 * @param seat
	 * @return
	 */
	public int buySeat(int price) {
		// TODO
		int i = 0; 


		boolean seatFound = false;

		while (i < seats.length && seatFound == false) {
			int j = 0; 
			while (j < seats[0].length && seatFound == false){
				if (price == seats[i][j] &&  seats[i][j] != 0) {
					System.out.println( "You bought seat " + (j + 1 ) + " in row "  + (i + 1) );
					seats[i][j] = 0;
					seatFound = true;
				}

				j++;
			}
			i++;
		}
		return price;


	}

	public void printTheaterFloor(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col] + "  ");
			}
			System.out.println();
		}
	}
}
