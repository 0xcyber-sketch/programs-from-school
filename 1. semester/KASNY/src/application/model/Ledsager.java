package application.model;

import java.util.ArrayList;

public class Ledsager {

	private String navn;
	private ArrayList<Udflugt> udflugter;
	private Tilmelding tilmelding;

	/**
	 * 
	 * @param navn
	 * @param tilmelding
	 */
	public Ledsager(String navn, Tilmelding tilmelding) {
		this.navn = navn;
		this.tilmelding = tilmelding;
		this.udflugter = new ArrayList<Udflugt>();
	}


	public ArrayList<Udflugt> getUdlugter() {
		return new ArrayList<>(udflugter);
	}
	
	/**
	 * 
	 * @param udflugt
	 */
	public void addUdflugt(Udflugt udflugt) {
		if (!udflugter.contains(udflugt)) {
			udflugter.add(udflugt);
			udflugt.addLedsager(this);
		}
	}

	/**
	 * 
	 * @param udflugt
	 */
	public void removeUdflugt(Udflugt udflugt) {
		if (udflugter.contains(udflugt)) {
			udflugter.remove(udflugt);
			udflugt.removeLedsager(this);
		}
	}

	public Tilmelding getTilmelding() {
		return tilmelding;
	}

	public void setTilmelding(Tilmelding tilmelding) {
		if (this.tilmelding != tilmelding) {
			this.tilmelding = tilmelding;
		}
	}

	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}

	
	

}