package opgave03;

public class FødeVare extends Vare {

	private int holdBarhedsPeriodeIDage;

	public FødeVare(String navn, String beskrivelse, double pris, int dage) {
		super(navn, beskrivelse, pris, 5);
		holdBarhedsPeriodeIDage = dage;
		
	}

	public int getHoldBarhedsPeriodeIDage() {
		return holdBarhedsPeriodeIDage;
	}

	public void setHoldBarhedsPeriodeIDage(int holdBarhedsPeriodeIDage) {
		this.holdBarhedsPeriodeIDage = holdBarhedsPeriodeIDage;
	}
	
	
}
