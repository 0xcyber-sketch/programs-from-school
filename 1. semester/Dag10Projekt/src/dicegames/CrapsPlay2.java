package dicegames;

import java.util.Scanner;

public class CrapsPlay2 {
	private boolean winner = false;
	private int comeOutRoll = 0;
	private Craps rolls;
	private Scanner scan; 
	private boolean finished = false;
	private int amountThrow = 0;
	private int games = 1;
	private int wins = 0;



	public CrapsPlay2(){
		rolls = new Craps();
		scan = new Scanner(System.in);

	}



	public void welcomeToGame(){
		// TODO Skriv komunikation senere. Eventuelt regler **
		System.out.println("SHabab");
	}

	public void gameOver() {
		if (winner) {
			System.out.println("Tillykke, spillet er vundet");
			wins++;
		}
		else {
			System.out.println("Ahhh du tabte, prøv igen");

		}
	}



	public void takeTurns() {
		rolls.rollBothDices();
		System.out.println(rolls.sumOfDices());



		if (amountThrow == 0){
			if ((rolls.sumOfDices() == 11 || rolls.sumOfDices() == 7) ) {
				winner = true;
				finished = true;
			}
			else if ((rolls.sumOfDices() == 2 || rolls.sumOfDices() == 3 || rolls.sumOfDices() == 12) ){
				winner = false;
				finished = true;}
			else {
				amountThrow++;
				comeOutRoll = rolls.sumOfDices();
			}

		}
		else {
			if (rolls.sumOfDices() == comeOutRoll) {
				finished = true;
				winner = true;
			}
			if (rolls.sumOfDices() == 7) {
				finished = true;
				winner = false;

			}
		}
	}

	public void startGame() {
		System.out.print("Ønsker du at spille?");
		String input = scan.nextLine();

		if (input.equalsIgnoreCase("Nej")) {
			System.out.println("Ses");
		}
		else {
			welcomeToGame();
			while (!finished) {
				takeTurns();
			}
			gameOver();
			playAgain();

		}
	}

	private void reset() {
		comeOutRoll = 0;
		amountThrow = 0;
		winner = false;
		finished = false;
	}

	private void playAgain() {
		
		boolean run = true;
		while (run) {
			System.out.print("Ønsker du at spille igen?");
			String input = scan.nextLine();
			if (input.equalsIgnoreCase("ja")) {
				games++;
				reset();
				while(!finished) {
				takeTurns();
				}
				gameOver();
				System.out.println();



			}
			else {
				stats();
				run = false;

			}
		}
	}

	private void stats() {
		System.out.println("Tak for spillet");
		System.out.println("Du har spillet : "+ games + " gange");
		System.out.println("Du har vundet : "+ wins + " gange");
		System.out.println("Du har tabt : "+ (games-wins) + " gange");
		
		
	}

}








