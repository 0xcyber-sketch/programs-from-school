package dicegames;

import java.util.Scanner;
import java.lang.Math;

public class PlayPig {

	// Deklaring af attributer

	private String player1;
	private String player2;
	private int p1Point;
	private int p2Point;
	private boolean run;
	private Pig roll;
	private Scanner scan;
	private int maxValue = 100;

	/*
	 * Lav to konstruktere, hvor pointene bliver nulstillet og den laver en spilleer
	 * 1 og spiller 2.
	 */
	PlayPig(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
		p1Point = 0;
		p2Point = 0;
		run = true;
		roll = new Pig();
		scan = new Scanner(System.in);

	}

	/**
	 * 
	 */
	PlayPig(String player1) {
		this.player1 = player1;
		this.player2 = "AI";
		p1Point = 0;
		p2Point = 0;
		run = true;
		roll = new Pig();
		scan = new Scanner(System.in);
	}

	/*
	 * Udskriv velkomst og regler
	 */
	private void welcomeToGame() {
		System.out.println("****************************");
		System.out.println("Regler: ");
		System.out.println("Hver spiller skiftes til at kaste med en terning indtil han enten kaster 1,\neller beslutter sig for at stoppe. Hvis han slåren 1’er, får han ingen point i denne omgang.\nHvis han beslutter sig for at stoppeinden har slår en 1’er, lægges summen af alle hans kast i denne tur sammenmed hans samlede antal point,\nog turen går videre til næste spiller.Den første spiller der samlet når 100 point har vundet. ");
		System.out.println("****************************");
		System.out.println();
	}

	// Udskriv vinderen. Den person/eller coomputeren som får 100 point først
	private void gameOver() {
		if (p1Point >= maxValue) {
			System.out.println(player1 + " vandt");

		}
		if (p2Point >= maxValue) {
			System.out.println(player2 + " vandt");

		}
	}

	/*
	 * Dette er koden hvor spillet foregår. Det kigger først efter om man vil spille
	 * mod computerenn eller en spiller 2. Spiller man mod med 2 spillere. Bliver
	 * man spurgt om man vil kaste terningen eller give turen videre. I mod
	 * computeren er det spilleren
	 * 
	 */
	private void takeTurns() {
		int oldPoint = 0;
		int pTurn = 1;

		// AI lokal variabler, som bruges til at håndtere AI's træk
		int randomNumber = 0;
		int max = 6;
		int min = 2;
		int range = max - min + 1; // AI'en bruger mellem 2 og 6 frosøg, hvis den ikke slår 1.
		int counter = 1; //tæller turer, som skal sammenlignes med det tilfældige nummer 

		String input;

		System.out.println("Vil du spille mod pvp?"); // Spørg om man vil spille mod en person, 
		//Hvis ja så spiller man 2 personer, ellers spiller man  mod computeren
		input = scan.nextLine();
		if (input.equalsIgnoreCase("ja")) {

			while (run) {
				// Spiller 1
				if (pTurn == 1) {
					System.out.println(player1);
					roll.rollDie();
					System.out.println(roll.showValue());
					oldPoint += roll.showValue();

					if (roll.showValue() == 1) {
						oldPoint = 0;
						pTurn *= -1;

					} else {
						System.out.println("Vil du fortsætte");
						input = scan.nextLine();
						if (input.equalsIgnoreCase("nej")) {
							p1Point += oldPoint;
							oldPoint = 0;
							pTurn *= -1;

						}
					}
					// Spiller 2
				} else if (pTurn != 1) {
					System.out.println(player2);
					roll.rollDie();
					System.out.println(roll.showValue());
					oldPoint += roll.showValue();

					if (roll.showValue() == 1) {
						oldPoint = 0;
						pTurn *= -1;

					} else {
						System.out.println("Vil du fortsætte");
						input = scan.nextLine();
						if (input.equalsIgnoreCase("nej")) {
							p2Point += oldPoint;
							oldPoint = 0;
							pTurn *= -1;
						}

					}

				}

				if (p1Point >= maxValue || p2Point >= maxValue) {
					run = false;
				}

				System.out.println("Stilling er \n " + player1 + " har: " + p1Point);
				System.out.println("" + player2 + " har: " + p2Point);

			}
		} else {
			System.out.println("AI it is");

			/*
			 *****************************************************
			 * *************************************************** 
			 * Start på AI handling.
			 * pTurn/spilleren ´s tur er præcist det samme, som ovenover.
			 */
			while (run) {
				// Spilleren
				if (pTurn == 1) {
					counter = 1;
					System.out.println(player1);
					roll.rollDie();
					System.out.println(roll.showValue());
					oldPoint += roll.showValue();

					if (roll.showValue() == 1) {
						oldPoint = 0;
						pTurn *= -1;
						randomNumber = (int) (Math.random() * range) + min;

					} else {
						System.out.println("Vil du fortsætte");
						input = scan.nextLine();
						if (input.equalsIgnoreCase("nej")) {
							p1Point += oldPoint;
							oldPoint = 0;
							randomNumber = (int) (Math.random() * range) + min;
							pTurn *= -1;

						}
						System.out.println(pTurn);
					}
					// AI'en
				} else if (pTurn != 1) {
					System.out.println(player2);
					roll.rollDie();
					System.out.println("AI slog " + roll.showValue());
					oldPoint += roll.showValue();

					if (roll.showValue() == 1) {
						oldPoint = 0;
						pTurn *= -1;

					} else {
						//Tjek om counter er = randomnummer. Hvilket er antal forsøg,
						//som computeren kaster før den skifter turen til spilleren.
						if (counter == randomNumber) {
							p2Point += oldPoint;
							oldPoint = 0;
							pTurn *= -1;
						}

					}
					counter++;

				}

				if (p1Point >= maxValue || p2Point >= maxValue) {
					run = false;
				}

				System.out.println("Stilling er \n" + player1 + " har: " + p1Point);
				System.out.println("" + player2 + " har: " + p2Point);

			}
		}

	}

	// Her sættes koden sammen og bliver faktisk kørt i rigtigt række følge.
	public void runGame() {
		welcomeToGame();
		takeTurns();
		gameOver();
	}

}
