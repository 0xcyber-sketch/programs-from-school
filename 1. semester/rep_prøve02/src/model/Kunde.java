package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
	@Override
	public String toString() {
		return navn;
	}

	private String navn;
	private String mobil;
	private ArrayList<Bestilling> bestillinger = new ArrayList<>();

	public Kunde(String navn, String mobil) {
		this.navn = navn;
		this.mobil = mobil;
	}

	public String getNavn() {
		return navn;
	}

	public String getMobil() {
		return mobil;
	}
	
	public ArrayList<Bestilling> getBestillinger(){
		return new ArrayList<>(bestillinger);
	}
	
	public void addBestilling(Bestilling b) {
		if (!bestillinger.contains(b)) {
			bestillinger.add(b);
			b.setKunde(this);
		}
	}
	
	 public ArrayList<Plads> bestiltePladserTilForestillingPådag(Forestilling forestilling, LocalDate dato) {
		 ArrayList<Plads> pladser = new ArrayList<>();
		 for (Bestilling b : getBestillinger()) {
			 if (b.getForestilling().equals(forestilling) && b.getDato().equals(dato)) {
				 for (Plads p : b.getPladser()) {
					 pladser.add(p);
				 }
			 }
		 }
		 return pladser;
	 }

}
