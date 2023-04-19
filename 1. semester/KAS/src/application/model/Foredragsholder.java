package application.model;

import java.util.ArrayList;

public class Foredragsholder extends Deltager {

	private String speciale;
	private ArrayList<Foredrag> foredrager = new ArrayList<>();

	public Foredragsholder(String navn, String adresse, String by_Land, String tlfNr, String speciale) {
		super(navn, adresse, by_Land, tlfNr);
		this.speciale = speciale;
	}
	
	public Foredragsholder(String navn, String adresse, String by_Land, String tlfNr, 
			String firmaNavn, String firmaTlfNr, String speciale) {
		super(navn, adresse, by_Land, tlfNr, firmaNavn, firmaTlfNr);
		this.speciale = speciale;
	}
	
	public ArrayList<Foredrag> getForedrager() {
		return new ArrayList<>(foredrager);
	}
	
	/**
	 * 
	 * @param foredrag
	 */
	public void addForedrag(Foredrag foredrag) {
		if (!foredrager.contains(foredrag)) {
			foredrager.add(foredrag);
			foredrag.setForedragsholder(this);
		}
	}

	/**
	 * 
	 * @param foredrag
	 */
	public void removeForedrag(Foredrag foredrag) {
		if (foredrager.contains(foredrag)) {
			foredrager.remove(foredrag);
			foredrag.setForedragsholder(null);
		}
	}

	public String getSpeciale() {
		return speciale;
	}

	public void setSpeciale(String speciale) {
		this.speciale = speciale;
	}
}