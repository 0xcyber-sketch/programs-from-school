package opgave03;

public class Spiritus extends Vare{

	private double alokoholProcent;

	public Spiritus(String navn, String beskrivelse, double pris, double alokoholProcent) {
		super(navn, beskrivelse, pris);
		this.alokoholProcent = alokoholProcent;
		if (pris > 90) {
			super.setMoms(120);
		}
		else {
			super.setMoms(80);
		}
	}

	public double getAlokoholProcent() {
		return alokoholProcent;
	}

	public void setAlokoholProcent(double alokoholProcent) {
		this.alokoholProcent = alokoholProcent;
	}
	
}
