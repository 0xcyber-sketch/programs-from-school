package opgave4;

/// Inspiration https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java

// Thanks AUther
public class RomanNumbers {
	private int input;


	public RomanNumbers(int input){
		this.input = input;
	}





	public String getNumbers() {
		String numbers;
		numbers = "";
		if (input > 0 && input < 4000) {
			if (input >= 1000 ) {
				if (input / 1000 == 3) { 
					numbers += "MMM";
					input -= 3000;
				}
				else if ( input / 1000 == 2) {
					numbers += "MM";
					input -= 2000;
				}
				else if (input / 1000 == 1) {
					numbers += "M";
					input -= 1000;
				
				}

			}
			if (input >= 900) {
				numbers += "CM";
				input -= 900;
			}

			if (input >= 500) {
				numbers += "D";
				input -= 500;
			}
			if (input >= 400) {
				numbers += "CD";
				input -= 400;
			}
			if (input >= 100) {
				numbers += "C";
				input -= 100;
			}
			if (input >= 90) {
				numbers += "XC";
				input -= 90;
			}
			if (input >= 50) {
				numbers += "L";
				input -= 50;
			}
			if (input >= 40) {
				numbers += "XL";
				input -= 40;
			}
			if (input >= 10) {
				numbers += "X";
				input -= 10;
			}
			if (input >= 9) {
				numbers += "IX";
				input -= 9;
			}
			if (input >= 8) {
				numbers += "VIII";
				input -= 8;
			}
			if (input >= 7) {
				numbers += "VII";
				input -= 7;
			}
			if (input >= 6) {
				numbers += "VI";
				input -= 6;
			}
			if (input >= 5) {
				numbers += "V";
				input -= 5;
			}
			if (input >= 4) {
				numbers += "IV";
				input -= 4;
			}
			if (input >= 3) {
				numbers += "III";
				input -= 3;
			}
			if (input >= 2) {
				numbers += "II";
				input -= 2;
			}
			if (input >= 1) {
				numbers += "I";
				input -= 1;
			}
		}




	
		
	else {
				numbers = "Unidentified";			
			}

		
		return numbers;

	}
}



