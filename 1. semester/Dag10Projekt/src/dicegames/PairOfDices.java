package dicegames;

/**
 * This class models one pair of dices.
 *
 */
public class PairOfDices {
    /**
     * The first die in the pair.
     */
	private Die die1;
	/**
	 * The second die in the pair.
	 */
	private Die die2;
	
	// attribut som husker hvor mange gange man har kastet terningerne
	private int amountOfThrows = 0;
	
	private int amountOfOne = 0;
	private int amountOfTwo = 0;
	private int amountOfThree = 0;
	private int amountOfFour = 0;
	private int amountOfFive = 0;
	private int amountOfSix = 0;
	
	private int amountOfPairs = 0;
	
	private int maxValue = 0;
	/*
	 * Parameterløs constructur Der starter die1 og die2 
	 * 	 */
	
	
	public PairOfDices(){
		die1 = new Die();
		die2 = new Die();
		//amountOfThrows = 0;
				
	}
	/*
	 *  constructur Der starter die1 og die2, Med antal overflader som parameter 
	 * 	 */
	public PairOfDices(int amountOfFaces){
		die1 = new Die(amountOfFaces);
		die2 = new Die(amountOfFaces);	
		//amountOfThrows = 0;
	}
	
	/*
	 *  Her kaster vi terninerne 
	 */
	public void rollBothDices() {
		die1.roll();
		die2.roll();
		amountOfThrows++;
		
		if (die1.getFaceValue() == 1 ) {
			amountOfOne++;
		}
		
		if (die2.getFaceValue() == 1 ) {
			amountOfOne++;
		}
		if (die1.getFaceValue() == 2 ) {
			amountOfTwo++;
		}
		
		if (die2.getFaceValue() == 2 ) {
			amountOfTwo++;
		}
		if (die1.getFaceValue() == 3 ) {
			amountOfThree++;
		}
		
		if (die2.getFaceValue() == 3 ) {
			amountOfThree++;
		}
		if (die1.getFaceValue() == 4 ) {
			amountOfFour++;
		}
		
		if (die2.getFaceValue() == 4 ) {
			amountOfFour++;
		}
		if (die1.getFaceValue() == 5 ) {
			amountOfFive++;
		}
		
		if (die2.getFaceValue() == 5 ) {
			amountOfFive++;
		}
		if (die1.getFaceValue() == 6 ) {
			amountOfSix++;
		}
		
		if (die2.getFaceValue() == 6 ) {
			amountOfSix++;
		}
		
		if (die1.getFaceValue() == die2.getFaceValue()) {
			amountOfPairs++;
		}
		
		if ( sumOfDices() > maxValue) {
			maxValue = sumOfDices();
		}
		
		
	}
	
	public int sumOfDices() {
		return die1.getFaceValue() + die2.getFaceValue();
	}
	
	public void restPairsOfDice() {
		amountOfOne = 0;
		amountOfTwo = 0;
		amountOfThree = 0;
		amountOfFour = 0;
		amountOfFive = 0;
		amountOfSix = 0;
		maxValue = 0;
		amountOfThrows = 0;
		amountOfPairs = 0;
	}
	public int getAmountOfThrows() {
		return amountOfThrows;
	}
	public int getAmountOfOne() {
		return amountOfOne;
	}
	public int getAmountOfTwo() {
		return amountOfTwo;
	}
	public int getAmountOfThree() {
		return amountOfThree;
	}
	public int getAmountOfFour() {
		return amountOfFour;
	}
	public int getAmountOfFive() {
		return amountOfFive;
	}
	public int getAmountOfSix() {
		return amountOfSix;
	}
	public int getAmountOfPairs() {
		return amountOfPairs;
	}
	public int getMaxValue() {
		return maxValue;
	}
	
	
	
}
