package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fag {
	private String navn;
	private String klasse;
	private ArrayList<Lektion> lektioner = new ArrayList<>();

	public Fag(String navn, String klasse) {
		this.navn = navn;
		this.klasse = klasse;
	}

	public String getNavn() {
		return navn;
	}

	public String getKlasse() {
		return klasse;
	}

	public ArrayList<Lektion> getLektioner() {
		return new ArrayList<>(lektioner);
	}

	public void addLektion(Lektion l) {
		if (!lektioner.contains(l)) {
			lektioner.add(l);
		}
	}

	public ArrayList<Studerende> sygdomPåDato(LocalDate dato) {
		ArrayList<Studerende> sygmeldte = new ArrayList<>();
		for (Lektion l : getLektioner()) {
			if (l.getDato() == dato) {
				for (Deltagelse d : l.getDeltagelser()) {
					if (!sygmeldte.contains(d.getStuderende()) && d.getStatus() == DeltagerStatus.SYG) {
						sygmeldte.add(d.getStuderende());
					}
				}
			}
		}
		return sygmeldte;
	}

	public Lektion mestFravær() {
		Lektion mestFravær = null;
		int max = Integer.MIN_VALUE;
		int fraVær = 0;

		for (Lektion l : getLektioner()) {
			for (Deltagelse d : l.getDeltagelser()) {
				if (d.erRegistreretFraværende()) {
					fraVær++;

				}

			}
			if (fraVær > max) {
				max = fraVær;
				mestFravær = l;
			} 
				fraVær = 0;
			
		}

		return mestFravær;
	}

	@Override
	public String toString() {
		return  navn + " "+ klasse;
	}
	

}
