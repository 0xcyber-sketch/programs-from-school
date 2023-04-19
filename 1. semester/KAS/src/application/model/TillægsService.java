package application.model;

import java.util.ArrayList;

public class TillægsService {
	private String beskrivelse;
	private double pris;
	private ArrayList<Tilmelding> tilmeldinger;
	
	 TillægsService(String beskrivelse, double pris) {
		this.beskrivelse = beskrivelse;
		this.pris = pris;
		tilmeldinger = new ArrayList<>();	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}
	
	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<>(tilmeldinger);
	}
	
	public void addTilmelding(Tilmelding tilmelding) {
		if (!tilmeldinger.contains(tilmelding)) {
			tilmeldinger.add(tilmelding);
			tilmelding.addTilllægService(this);
		}
	}
	public void removeTilmelding(Tilmelding tilmelding) {
		if (tilmeldinger.contains(tilmelding)) {
			tilmeldinger.remove(tilmelding);
			tilmelding.removeTilllægService(this);
		}
	}
	
	@Override
	public String toString() {
		return beskrivelse + " : " + pris + "kr";
	}
}
