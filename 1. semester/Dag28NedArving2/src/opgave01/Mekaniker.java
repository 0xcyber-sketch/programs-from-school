package opgave01;

public class Mekaniker extends Ansat{
	private double timeLøn;
	private int svendePrøveÅr;
	
	public Mekaniker(String navn, String adresse, double timeLøn, int svendePrøveÅr) {
		super(navn, adresse, timeLøn);
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

	@Override
	public double bergnUgeLøn() {
		return super.getTimeLøn() * 37;
	}
	
	
	

}
