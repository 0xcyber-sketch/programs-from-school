package dicegames;

public class Craps {
	private Die die1;
	private Die die2;
	
	
	public Craps(){
		die1 = new Die();
		die2 = new Die();
	}
	public Craps(int amountOfFaces){
		die1 = new Die(amountOfFaces);
		die2 = new Die(amountOfFaces);	
	}
	
	public int sumOfDices() {
		return die1.getFaceValue() + die2.getFaceValue();
	}
	
	public void rollBothDices() {
		die1.roll();
		die2.roll();
	}
	
	
	
	
	
}
