package dicegames;

/*
 * Samme pincip som Craps klassen
 */
public class Pig {

	private Die die;
	
	public Pig(){
		die = new Die();		
	}
	
	public Pig(int amountOfFaces){
		die = new Die(amountOfFaces);		
	}
	
	public void rollDie() {
		die.roll();
	}
	
	public int showValue() {
		return die.getFaceValue();
	}
	
}

