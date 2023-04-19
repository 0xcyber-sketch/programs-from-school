package application.model;

import java.util.ArrayList;

public class Arrangement {

	private String navn;
	private boolean offentlig;
	private final ArrayList<Reservation> reservationer= new ArrayList<>();
	
	
	public Arrangement(String navn, boolean offentlig) {
		this.navn = navn;
		this.offentlig = offentlig;
	}


	public boolean isOffentlig() {
		return offentlig;
	}


	public void setOffentlig(boolean offentlig) {
		this.offentlig = offentlig;
	}


	public String getNavn() {
		return navn;
	}
	
	public ArrayList<Reservation> getReservation() {
		return new ArrayList<>(reservationer);
	}
	/***
	 *  Adds the reservation to this arrangement,*
	 *   if they aren't connected.*
		Pre: The reservation isn't connected to another arrangement.
		*/
	
	
	public void addReservation(Reservation reservation) {
		if (!reservationer.contains(reservation)) {
			reservationer.add(reservation);
		}
	}
	
	/*** Removes the reservation from this arrangement,
	 * * if they are connected.*/
	public void removeReservation(Reservation reservation) {
		if (reservationer.contains(reservation)) {
			reservationer.remove(reservation);
		}
	}
	
	public int antalReserveredePladser() {
		int sum = 0;
		
		for (Reservation r: reservationer) {
		sum += r.getPlads().size();
		}
			return sum;
	}
}
