package application.model;

import java.util.ArrayList;

public class Tutor {
	private String navn;
	private String email;
	private Hold hold;
	private ArrayList<Arrangement> arrangementer = new ArrayList<>();
	
	public Tutor(String navn, String email) {
		this.navn = navn;
		this.email = email;
	}

	public String getNavn() {
		return navn;
	}

	public String getEmail() {
		return email;
	}
	
	public Hold getHold() {
		return hold;
	}
	
	public void setHold(Hold h) {
		if (this.hold != h) {
			if (this.hold != null) {
				h.removeTutor(this);
			}
			this.hold = h;
			if (h != null) {
				hold.addTutor(this);
			}
		}
	}
	
	public ArrayList<Arrangement> getArrangementer(){
		return new ArrayList<>(arrangementer); 
	}
	
	public void addArrangement(Arrangement a) {
		if (!arrangementer.contains(a)) {
			arrangementer.add(a);
		}
	}
	
	public double arrangementPris() {
		double pris = 0;
		for (Arrangement a : arrangementer) {
			pris += a.getPris();
		}
		return pris;
		
	}
	
	public String toString() {
		return navn;
	}
	
	

	

}
