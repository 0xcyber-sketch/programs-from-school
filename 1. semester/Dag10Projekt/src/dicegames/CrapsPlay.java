package dicegames;

import java.util.Scanner;

public class CrapsPlay {
	// Deklaring af attributer, som vi bruger igennem hele klassen
	private boolean winner = false;
	private int comeOutRoll = 0;
	private Craps rolls;
	private Scanner scan;
	private boolean runTurn = true;

	/*
	 * Opretter en constructer, Laver en variable rolls med typen craps, som styrer
	 * terningerne. Og en scanner så vi kan tage user input
	 */

	//
	public CrapsPlay() {
		rolls = new Craps();
		scan = new Scanner(System.in);

	}

	// Her siger vi velkommen til spillet og fortæller om reglerne.
	public void welcomeToGame() {
		// TODO Skriv komunikation senere. Eventuelt regler **
		System.out.println("Regler. bla bla bla.");
	}

	// Gameover er teksten der viser om spilleren har vundet eller tabt når spillet
	// er færdig
	// Vi bruger en if og en bool ti lat tjekke om man har vundet
	public void gameOver() {
		if (winner) {
			System.out.println("Tillykke, spillet er vundet");
		} else {
			System.out.println("Ahhh du tabte, prøv igen");

		}
	}

	/*
	 * Her slår spilleren med terningerne terningerne. Første tur tjekker når man om
	 * man slår 11 eller 7. Hvis man gør vinder man. Hvis man derimod slå 2,3,12
	 * så taber man. Ellers hvis man slår alt andet bliver man ved med at slå indtil
	 * man slår, Det første man slog og vinder, eller man slår 7 og taber
	 * 
	 * 
	 */
	public void takeTurns() {
		rolls.rollBothDices(); // Rolls dices
		System.out.println(rolls.sumOfDices());
		int amountThrow = 0; // Make local variable
		//Make while loop that runs until runTurn is false
		while (runTurn) {
			if (amountThrow == 0) {
				if ((rolls.sumOfDices() == 11 || rolls.sumOfDices() == 7)) {
					winner = true;
					runTurn = false;
				} else if ((rolls.sumOfDices() == 2 || rolls.sumOfDices() == 3 || rolls.sumOfDices() == 12)) {
					winner = false;
					runTurn = false;
				} else {
					comeOutRoll = rolls.sumOfDices();
					amountThrow++;

				}
			} else {

				rolls.rollBothDices();
				System.out.println(rolls.sumOfDices());
				if (rolls.sumOfDices() == comeOutRoll) {
					runTurn = false;
					winner = true;
				}
				if (rolls.sumOfDices() == 7) {
					runTurn = false;
					winner = false;

				}
			}

		}
	}

	/*
	 * Dette er vores spil metode. Eher kalder vi alle vores metoder, som vi har lavet.
	 */
	public void startGame() {
		System.out.print("Ønsker du at spille?");
		String input = scan.nextLine();
		if (input.equalsIgnoreCase("Nej")) {
			System.out.println("Ses");
		} else {
			welcomeToGame();
			takeTurns();
			gameOver();
		}
	}

}
