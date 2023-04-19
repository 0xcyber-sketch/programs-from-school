package opgave02;

public class Mekaniker extends Person{
	private double timeLøn;
	private int svendePrøveÅr;
	
	public Mekaniker(String navn, String adresse, double timeLøn, int svendePrøveÅr) {
		super(navn, adresse);
		this.timeLøn = timeLøn;
		this.svendePrøveÅr = svendePrøveÅr;
		
	}

	public double getTimeLøn() {
		return timeLøn;
	}

	public void setTimeLøn(double timeLøn) {
		this.timeLøn = timeLøn;
	}

	public int getSvendePrøveÅr() {
		return svendePrøveÅr;
	}

	public void setSvendePrøveÅr(int svendePrøveÅr) {
		this.svendePrøveÅr = svendePrøveÅr;
	}
	
	public double bergnUgeLøn() {
		return timeLøn * 37;
	}
	
	

}
