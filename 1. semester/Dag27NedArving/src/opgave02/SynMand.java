package opgave02;

public class SynMand extends Mekaniker{

	private int syn;
	private double tillæg;
	public SynMand(String navn, String adresse, double timeLøn, int svendePrøveÅr, int syn) {
		super(navn, adresse, timeLøn, svendePrøveÅr);
		// TODO Auto-generated constructor stub
		this.syn = syn; 
		tillæg = syn * 29;
	}
	public int getSyn() {
		return syn;
	}
	public void setSyn(int syn) {
		this.syn = syn;
	}
	public double getTillæg() {
		return tillæg;
	}
	public void setTillæg(double tillæg) {
		this.tillæg = tillæg;
	}
	
	@Override
	public double bergnUgeLøn() {
		return super.bergnUgeLøn() + tillæg;
	}
	
	
}
