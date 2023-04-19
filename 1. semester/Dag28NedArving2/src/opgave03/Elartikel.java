package opgave03;

public class Elartikel extends Vare{
	private int gennemsnitligForBrug;

	public Elartikel(String navn, String beskrivelse, double pris, int gennemsnitligForBrug) {
		super(navn, beskrivelse, pris, 30);
		this.gennemsnitligForBrug = gennemsnitligForBrug;
	}

	public int getGennemsnitligForBrug() {
		return gennemsnitligForBrug;
	}

	public void setGennemsnitligForBrug(int gennemsnitligForBrug) {
		this.gennemsnitligForBrug = gennemsnitligForBrug;
	}
	
	@Override
	public double beregnIndkøbsPris() {
		double pris = this.getPris();
//		double moms = pris * (super.getMoms() * 0.01);
		double moms = super.beregnMoms();
		if (moms < 3) {
			moms = 3;
		}
		return pris + moms;
		 
	}
	
	
}
