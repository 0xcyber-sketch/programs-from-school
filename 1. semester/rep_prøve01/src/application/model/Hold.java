package application.model;

import java.util.ArrayList;

public class Hold {

	private String betegnelse;
	private String holdLeder;
	private Uddannelse uddannelse;
	private ArrayList<Tutor> tutorer = new ArrayList<>();
	
	
	

	public Hold(String betegnelse, String holdLeder, Uddannelse uddannelse) {
		this.betegnelse = betegnelse;
		this.holdLeder = holdLeder;
		this.uddannelse = uddannelse;
		
	}

	public String getBetegnelse() {
		return betegnelse;
	}

	public String getHoldLeder() {
		return holdLeder;
	}

	public Uddannelse getUddannelse() {
		return uddannelse;
	}
	
	public ArrayList<Tutor> getTutor(){
		return new ArrayList<>(tutorer);
	}
	
	public void addTutor(Tutor t) {
		if (!tutorer.contains(t)) {
			tutorer.add(t);
			t.setHold(this);
		}
		
	}
	public void removeTutor(Tutor t) {
		if (tutorer.contains(t)) {
			tutorer.remove(t);
			t.setHold(null);
		}
		
	}
	
	public double arrangementPris() {
		double pris = 0;
		for (Tutor t : tutorer) {
			pris += t.arrangementPris();
		}
		return pris;
		
	}
	
	public boolean harTidsoverlap(Arrangement a) {
		boolean found = false;
		ArrayList<Arrangement> templiste = new ArrayList<>();
		
		for (Tutor t : tutorer) {
			for (Arrangement aran : t.getArrangementer()) {
				templiste.add(aran);
			}
		}
		int i = 0;
		while (!found && i < templiste.size() - 1) {
			if (templiste.get(i).getSlutTid().isBefore(templiste.get(i+1).getStartTid()) && templiste.get(i).getDate().isEqual(templiste.get(i+1).getDate())) {
				found = true;
			}
			else {
				i++;
			}
		}
		
		
		return found;
		
	}
	
	public String toString() {
		return this.betegnelse;
	}

}
