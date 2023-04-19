package opgave01;

public class Værkfører extends Ansat{
	private double tilLægsLøn;
	private int værkførerÅr;

	public Værkfører(String navn, String adresse, double timeLøn, double tilLægsLøn, int værkførerÅr) {
		super(navn,adresse, timeLøn);
		this.tilLægsLøn = tilLægsLøn;
		this.værkførerÅr = værkførerÅr;
	}

	public double getTilLægsLøn() {
		return tilLægsLøn;
	}

	public int getVærkførerÅr() {
		return værkførerÅr;
	}
	
	@Override
	public double bergnUgeLøn() {
		return (super.getTimeLøn() * 37) + tilLægsLøn;
	}
}
