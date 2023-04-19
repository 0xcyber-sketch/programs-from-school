package opgave4;

public class Cards {


	private String notation;
	
	
	public Cards(String notations){
		this.notation = notations;
	}
	
	public String getDescription() {
		String description = "";
		String symbol = "";
		
		// Check if notation contains C (Clubs)
		if (this.notation.substring(0,this.notation.length()-1).contains("C")) {
			symbol = "Clubs";
			if (this.notation.contains("A")) {
				description = "Ace of "+ symbol;
			}
			else if (this.notation.contains("2")){
				description = "Two of " + symbol;
			}
			else if (this.notation.contains("3")){
				description = "Three of " + symbol;
			}
			else if (this.notation.contains("4")){
				description = "Four of " + symbol;
			}
			else if (this.notation.contains("5")){
				description = "Five of " + symbol;
			}
			else if (this.notation.contains("6")){
				description = "Six of " + symbol;
			}
			else if (this.notation.contains("7")){
				description = "Seven of " + symbol;
			}
			else if (this.notation.contains("8")){
				description = "Eight of " + symbol;
			}
			else if (this.notation.contains("9")){
				description = "Nine of " + symbol;
			}
			else if (this.notation.contains("10")){
				description = "Ten of " + symbol;
			}
			else if (this.notation.contains("J")){
				description = "Jack of " + symbol;
			}
			else if (this.notation.contains("Q")){
				description = "Queen of " + symbol;
			}
			else if (this.notation.contains("K")){
				description = "King of " + symbol;
			}

			
			
		}
		// Check if notation contains H (Hearts)
		else if (this.notation.substring(0,this.notation.length()-1).contains("H")) {
			symbol = "Hearts";
			if (this.notation.contains("A")) {
				description = "Ace of "+ symbol;
			}
			else if (this.notation.contains("2")){
				description = "Two of " + symbol;
			}
			else if (this.notation.contains("3")){
				description = "Three of " + symbol;
			}
			else if (this.notation.contains("4")){
				description = "Four of " + symbol;
			}
			else if (this.notation.contains("5")){
				description = "Five of " + symbol;
			}
			else if (this.notation.contains("6")){
				description = "Six of " + symbol;
			}
			else if (this.notation.contains("7")){
				description = "Seven of " + symbol;
			}
			else if (this.notation.contains("8")){
				description = "Eight of " + symbol;
			}
			else if (this.notation.contains("9")){
				description = "Nine of " + symbol;
			}
			else if (this.notation.contains("10")){
				description = "Ten of " + symbol;
			}
			else if (this.notation.contains("J")){
				description = "Jack of " + symbol;
			}
			else if (this.notation.contains("Q")){
				description = "Queen of " + symbol;
			}
			else if (this.notation.contains("K")){
				description = "King of " + symbol;
			}
		}
		// Check if notation contains S (Spades)
		else if (this.notation.substring(0,this.notation.length()-1).contains("S")) {
			symbol = "Spades";
			if (this.notation.contains("A")) {
				description = "Ace of "+ symbol;
			}
			else if (this.notation.contains("2")){
				description = "Two of " + symbol;
			}
			else if (this.notation.contains("3")){
				description = "Three of " + symbol;
			}
			else if (this.notation.contains("4")){
				description = "Four of " + symbol;
			}
			else if (this.notation.contains("5")){
				description = "Five of " + symbol;
			}
			else if (this.notation.contains("6")){
				description = "Six of " + symbol;
			}
			else if (this.notation.contains("7")){
				description = "Seven of " + symbol;
			}
			else if (this.notation.contains("8")){
				description = "Eight of " + symbol;
			}
			else if (this.notation.contains("9")){
				description = "Nine of " + symbol;
			}
			else if (this.notation.contains("10")){
				description = "Ten of " + symbol;
			}
			else if (this.notation.contains("J")){
				description = "Jack of " + symbol;
			}
			else if (this.notation.contains("Q")){
				description = "Queen of " + symbol;
			}
			else if (this.notation.contains("K")){
				description = "King of " + symbol;
			}
		}
		// Check if notation contains D (Diamonds)
		else if (this.notation.substring(0,this.notation.length()-1).contains("D")) {
			symbol = "Diamonds";
			if (this.notation.contains("A")) {
				description = "Ace of "+ symbol;
			}
			else if (this.notation.contains("2")){
				description = "Two of " + symbol;
			}
			else if (this.notation.contains("3")){
				description = "Three of " + symbol;
			}
			else if (this.notation.contains("4")){
				description = "Four of " + symbol;
			}
			else if (this.notation.contains("5")){
				description = "Five of " + symbol;
			}
			else if (this.notation.contains("6")){
				description = "Six of " + symbol;
			}
			else if (this.notation.contains("7")){
				description = "Seven of " + symbol;
			}
			else if (this.notation.contains("8")){
				description = "Eight of " + symbol;
			}
			else if (this.notation.contains("9")){
				description = "Nine of " + symbol;
			}
			else if (this.notation.contains("10")){
				description = "Ten of " + symbol;
			}
			else if (this.notation.contains("J")){
				description = "Jack of " + symbol;
			}
			else if (this.notation.contains("Q")){
				description = "Queen of " + symbol;
			}
			else if (this.notation.contains("K")){
				description = "King of " + symbol;
			}
		}
		
		
		else {
			description = "Unknown";
		}
		
		
		return description;
	}
}
	
