package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Konference {

	private String navn;
	private String beskrivelse;
	private LocalDateTime startDato;
	private String adresse;
	private double pris;
	private LocalDateTime slutDato;
	private ArrayList<Udflugt> udflugter;
	private ArrayList<Tilmelding> tilmeldinger;
	private ArrayList<Foredrag> foredrager;
	private ArrayList<Hotel> hoteller; // Har vi oprettet disse?

	public Konference(String navn, String beskrivelse, LocalDateTime startDato, String adresse, double pris,
			LocalDateTime slutDato) {
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.startDato = startDato;
		this.adresse = adresse;
		this.pris = pris;
		this.slutDato = slutDato;
		this.udflugter = new ArrayList<>();
		this.tilmeldinger = new ArrayList<>();
		this.foredrager = new ArrayList<>();
		this.hoteller = new ArrayList<>();
	}

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<>(udflugter);
	}

	/**
	 * 
	 * @param sted
	 * @param startTid
	 * @param pris
	 * @param beskrivelse
	 */
	public Udflugt createUdflugt(String sted, LocalDateTime startTid, double pris, String beskrivelse) {
		Udflugt udflugt = new Udflugt(sted, startTid, pris, beskrivelse);
		udflugter.add(udflugt);
		return udflugt;
	}

	/**
	 * 
	 * @param udflugt
	 */
	public void deleteUdflugt(Udflugt udflugt) {
		if (udflugter.contains(udflugt)) {
			udflugter.remove(udflugt);
			for (Ledsager ledsager : udflugt.getLedsagere()) {
				udflugt.removeLedsager(ledsager);
			}
		}
	}

	public ArrayList<Foredrag> getForedrager() {
		return new ArrayList<Foredrag>(foredrager);
	}

	public Foredrag createForedrag(String emne, LocalDateTime startTid, double varighed) {
		Foredrag foredrag = new Foredrag(emne, startTid, varighed, this);
		foredrager.add(foredrag);
		return foredrag;
	}

	public void deleteForedrag(Foredrag foredrag) {
		if (foredrager.contains(foredrag)) {
			foredrag.setForedragsholder(null);
			foredrag.setKonference(null);
			foredrager.remove(foredrag);
		}
	}

	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<Tilmelding>(tilmeldinger);
	}
	
	public void addTilmelding(Tilmelding tilmelding) {
		if (!tilmeldinger.contains(tilmelding)) {
			tilmeldinger.add(tilmelding);
			tilmelding.setKonference(this);
		}
	}
	
	public void removeTilmelding(Tilmelding tilmelding) {
		if (tilmeldinger.contains(tilmelding)) {
			tilmeldinger.add(tilmelding);
			tilmelding.setKonference(null);
			tilmelding.setHotel(null);
			tilmelding.setDeltager(null);
			tilmelding.deleteLedsager();
			
		}
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public LocalDateTime getStartDato() {
		return startDato;
	}

	public void setStartDato(LocalDateTime startDato) {
		this.startDato = startDato;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public LocalDateTime getSlutDato() {
		return slutDato;
	}

	public void setSlutDato(LocalDateTime slutDato) {
		this.slutDato = slutDato;
	}

	public ArrayList<Hotel> getHoteller() {
		return new ArrayList<>(hoteller);
	}

	public void addHotel(Hotel hotel) {
		if (!hoteller.contains(hotel)) {
			hoteller.add(hotel);
		}
	}

	public void removeHotel(Hotel hotel) {
		if (hoteller.contains(hotel)) {
			hoteller.remove(hotel);
		}
	}
	
	@Override
	public String toString() {
		return navn;
	}
}