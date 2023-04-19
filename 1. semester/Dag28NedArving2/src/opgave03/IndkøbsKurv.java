package opgave03;

import java.util.ArrayList;

public class IndkøbsKurv {

	private ArrayList<Vare> varer;
//	private Vare vare;

	public IndkøbsKurv() {
		this.varer = new ArrayList<>();
	} 
	
	public void addVarer(Vare vare) {
		if (!varer.contains(vare)) {
			varer.add(vare);
		}
	}
	public void removeVarer(Vare vare) {
		if (varer.contains(vare)) {
			varer.remove(vare);
		}
	}
	
	public void removeAllVarer(Vare vare) {
		varer.clear();
	}
	
	public ArrayList<Vare> getVarer (){
		return new ArrayList<>(varer);
	}
	
	public double beregnTotalPris() {
		double sum = 0;
		for (Vare v : getVarer()) {
			sum += v.beregnIndkøbsPris();
		}
		return sum;
	}
	
	
	
	
	
	

}
