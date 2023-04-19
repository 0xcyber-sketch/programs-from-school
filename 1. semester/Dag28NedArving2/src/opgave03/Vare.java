package opgave03;

public class Vare {
	private String navn;
	private String beskrivelse;
	private double pris;
	private int moms;
	
	public Vare(String navn, String beskrivelse, double pris, int moms ) {
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.pris = pris;
		this.moms = moms;
	}
	public Vare(String navn, String beskrivelse, double pris ) {
		this(navn, beskrivelse, pris, 25);
	}

	
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}
	public int getMoms() {
		return moms;
	}
	public void setMoms(int moms) {
		this.moms = moms;
	}
	
	public double beregnIndkøbsPris() {
		return this.getPris() * (1 +(this.getMoms() * 0.01));
	}
	
	public double beregnMoms() {
		return (this.getPris() * (this.getMoms() * 0.01));
	}
	
	public String toString() {
		return this.getNavn() + "\t\t: " + this.pris;	
	}
}
