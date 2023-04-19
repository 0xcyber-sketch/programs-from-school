package application.model;

import java.util.ArrayList;

public class Deltager {

	private String navn;
	private String adresse;
	private String by_Land;
	private String tlfNr;
	private String firmaNavn;
	private String firmaTlfNr;
	private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

	/**
	 * 
	 * @param navn
	 * @param adresse
	 * @param by_Land
	 * @param tlfNr
	 */
	public Deltager(String navn, String adresse, String by_Land, String tlfNr) {
		this.navn = navn;
		this.adresse = adresse;
		this.by_Land = by_Land;
		this.tlfNr = tlfNr;
		this.firmaNavn = "";
		this.firmaTlfNr = "";
	}

	/**
	 * 
	 * @param navn
	 * @param adresse
	 * @param by_Land
	 * @param tlfNr
	 * @param firmaNavn
	 * @param firmaTlfNr
	 */
	public Deltager(String navn, String adresse, String by_Land, String tlfNr, String firmaNavn, String firmaTlfNr) {
		this.navn = navn;
		this.adresse = adresse;
		this.firmaNavn = firmaNavn;
		this.by_Land = by_Land;
		this.tlfNr = tlfNr;
		this.firmaTlfNr = firmaTlfNr;

	}

	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<Tilmelding>(tilmeldinger);
	}
	
	/**
	 * 
	 * @param tilmelding
	 */
	public void addTilmelding(Tilmelding tilmelding) {
		if (!tilmeldinger.contains(tilmelding)) {
			tilmeldinger.add(tilmelding);
			tilmelding.setDeltager(this);
		}
	}

	/**
	 * 
	 * @param tilmelding
	 */
	public void removeTilmelding(Tilmelding tilmelding) {
		if (tilmeldinger.contains(tilmelding)) {
			tilmeldinger.remove(tilmelding);
			tilmelding.setDeltager(null);
		}
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getFirmaNavn() {
		return firmaNavn;
	}

	public void setFirmaNavn(String firmaNavn) {
		this.firmaNavn = firmaNavn;
	}

	public String getBy_Land() {
		return by_Land;
	}

	public void setBy_Land(String by_Land) {
		this.by_Land = by_Land;
	}

	public String getTlfNr() {
		return tlfNr;
	}

	public void setTlfNr(String tlfNr) {
		this.tlfNr = tlfNr;
	}

	public String getFirmaTlfNr() {
		return firmaTlfNr;
	}

	public void setFirmaTlfNr(String firmaTlfNr) {
		this.firmaTlfNr = firmaTlfNr;
	}

	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
}