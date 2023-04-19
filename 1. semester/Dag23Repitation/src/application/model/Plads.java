package application.model;

import java.util.ArrayList;

public class Plads {

	private int nr;
	private Område område;
	private final ArrayList<Reservation> reservationer = new ArrayList<>();
	private static int timePris = 50;
	
	
	public static int getTimePris() {
		return timePris;
	}


	public static void setTimePris(int timePris) {
		Plads.timePris = timePris;
	}


	public Plads(int nr, Område område) {
		this.nr = nr;
		this.område = område;
	}


	public int getNr() {
		return nr;
	}


	public void setNr(int nr) {
		this.nr = nr;
	}


	public Område getOmråde() {
		return område;
	}


	public void setOmråde(Område område) {
		this.område = område;
	}
	
	public ArrayList<Reservation> getReservationer () {
		return new ArrayList<>(reservationer);
	}
	
	public void addReservation(Reservation reservation) {
		if (!reservationer.contains(reservation)) {
			reservationer.add(reservation);
			reservation.addPlads(this);
		}
	}
	
	public void removeReservation(Reservation reservation) {
		if (reservationer.contains(reservation)) {
			reservationer.remove(reservation);
			reservation.removePlads(this);
		}
	}
	
	public double pris (int timer) {
		double pris = 0;
		if (område == Område.VIP) {
			pris = 1.25 * timePris;
		}
		else if (område == Område.BØRNE) {
			pris = 0.8 * timePris;
		}
		else if (område == Område.TURNERING) {
			pris = 1.2 * timePris;
		}
		else {
			pris = timePris;
		}
		
		return pris * timer;
	}
	@Override
	public String toString() {
		return "Plads " + nr + ", " + getOmråde();
	}
}
