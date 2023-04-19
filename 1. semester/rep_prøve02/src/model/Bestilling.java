package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
	private LocalDate dato;
	private Forestilling forestilling;
	private Kunde kunde;
	private ArrayList<Plads> pladser = new ArrayList<>();

	 Bestilling(LocalDate dato, Forestilling forestilling, Kunde kunde) {
		this.dato = dato;
		this.forestilling = forestilling;
		this.kunde = kunde;
		kunde.addBestilling(this);
		
		
	}

	@Override
	public String toString() {
		return "Bestilling til " + forestilling;
	}

	public LocalDate getDato() {
		return dato;
	}
	
	public Forestilling getForestilling() {
		return this.forestilling;
	}
	
	public Kunde getKunde() {
		return kunde;
	}
	
	public void setKunde(Kunde k) {
		if (this.kunde != k) {
			this.kunde = k;
			k.addBestilling(this);
		}
	}
	
	public ArrayList <Plads> getPladser(){
		return new ArrayList<>(pladser);
	}
	
	public void addPlads(Plads p) {
		if (!pladser.contains(p)){
			pladser.add(p);
		}
	}
	
	public int samletPris() {
		int pris = 0;
		for (Plads p : getPladser()) {
			pris += p.getPris();
		}
		return pris;
	}
	

}
