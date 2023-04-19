package opgave01;

public class ArbejdsDreng extends Ansat{

	public ArbejdsDreng(String navn, String adresse, double timeLøn) {
		super(navn, adresse, timeLøn);
		
	}
	
	public double bergnUgeLøn() {
		return super.getTimeLøn() * 25;
	}
}
