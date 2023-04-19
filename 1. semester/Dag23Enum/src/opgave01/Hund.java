package opgave01;

public class Hund {
	private String navn;
	private int pris;
	private boolean stamtavle;
	private Race race;
	
	public Hund (String navn, int pris , boolean stamavle, Race race) {
		this.navn = navn;
		this.pris = pris;
		this.stamtavle = stamavle;
		this.race = race;
		
	}

	public String getNavn() {
		return navn;
	}

	public int getPris() {
		return pris;
	}

	public boolean isStamtavle() {
		return stamtavle;
	}

	public Race getRace() {
		return race;
	}

}
