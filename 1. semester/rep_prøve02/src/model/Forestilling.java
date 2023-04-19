package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {

	@Override
	public String toString() {
		return navn;
	}

	private String navn;
	private LocalDate startDate;
	private LocalDate slutDate;
	private ArrayList<Bestilling> bestillinger = new ArrayList<Bestilling>();

	public Forestilling(String navn, LocalDate startDate, LocalDate slutDate) {
		this.navn = navn;
		this.startDate = startDate;
		this.slutDate = slutDate;
	}

	public String getNavn() {
		return navn;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getSlutDate() {
		return slutDate;
	}

	public Bestilling createBestilling(LocalDate dato, Kunde kunde) {
		Bestilling b = new Bestilling(dato, this, kunde);
		bestillinger.add(b);
		return b;
	}

	public ArrayList<Bestilling> getbestillinger() {
		return new ArrayList<>(bestillinger);
	}

	public int antalBestiltePladserPåDag(LocalDate dato) {
		int pladser = 0;

		for (Bestilling b : getbestillinger()) {
			if (dato == b.getDato()) {
				pladser += b.getPladser().size();
			}
		}

		return pladser;
	}

	public LocalDate succesDato() {
		int max = Integer.MIN_VALUE;
		LocalDate date = null;
		for (Bestilling b : getbestillinger()) {
			int temp = antalBestiltePladserPåDag(b.getDato());
			if (max < temp) {
				max = temp;
			}
		}
		boolean found = false;
		int i = 0;
		while (!found && i <= getbestillinger().size()) {
			Bestilling b = getbestillinger().get(i);
			if (antalBestiltePladserPåDag(b.getDato()) == max) {
				found = true;
				date = b.getDato();
			} else {
				i++;
			}
		}

		return date;

	}

	public boolean erPladsLedig(int række, int nr, LocalDate dato) {
		ArrayList<Plads> pladser = new ArrayList<>();
		for (Bestilling b : bestillinger) {
			for (Plads p : b.getPladser()) {
				pladser.add(p);
			}

		}

		boolean ledig = true;
		int i = 0;

		while (ledig && i < pladser.size()) {
			if (pladser.get(i).getNr() == nr && pladser.get(i).getRække() == række) {
				ledig = false;
			} else {
				i++;
			}
		}

		return ledig;
	}

}
