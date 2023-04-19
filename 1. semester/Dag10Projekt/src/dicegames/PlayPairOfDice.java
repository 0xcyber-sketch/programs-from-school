package dicegames;
import java.util.Scanner;

public class PlayPairOfDice {
	
	private Scanner scan = new Scanner(System.in);
	private boolean runGame = true;
	private PairOfDices rolls;
	
	public PlayPairOfDice(){
		rolls = new PairOfDices();
	}
	
	public void endGame() { {
			System.out.println("Antal slag : " + rolls.getAmountOfThrows());
			System.out.println("1'er: " + rolls.getAmountOfOne());
			System.out.println("2'er: " + rolls.getAmountOfTwo());
			System.out.println("3'er: " + rolls.getAmountOfThree());
			System.out.println("4'er: " + rolls.getAmountOfFour());
			System.out.println("5'er: " + rolls.getAmountOfFive());
			System.out.println("6'er: " + rolls.getAmountOfSix());
			System.out.println("Antal par: " + rolls.getAmountOfOne());
			System.out.println("Det højste tal du har slået er: " + rolls.getMaxValue());
		}
		
	}
	

	

	public void runGame() {
		
		
		
		while (runGame) {
			System.out.println("Vil du spille?");
			String input = scan.nextLine();
			if (input.equalsIgnoreCase("Nej")) {
				runGame = false;
			}
			rolls.rollBothDices();
			System.out.println("Du slog: \n " + rolls.sumOfDices());
			
		}
		
		System.out.println(("Spillet er slut: "));
		endGame();
		
	}

}
