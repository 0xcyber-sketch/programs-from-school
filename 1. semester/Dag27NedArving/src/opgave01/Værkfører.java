package opgave01;

public class Værkfører extends Mekaniker{
	private double tilLægsLøn;
	private int værkførerÅr;

	public Værkfører(String navn, String adresse, double timeLøn, int svendePrøveÅr, double tilLægsLøn, int værkførerÅr) {
		super(navn,adresse,timeLøn, svendePrøveÅr);
		this.tilLægsLøn = tilLægsLøn;
		this.værkførerÅr = værkførerÅr;
	}

	public double getTilLægsLøn() {
		return tilLægsLøn;
	}

	public int getVærkførerÅr() {
		return værkførerÅr;
	}
}
